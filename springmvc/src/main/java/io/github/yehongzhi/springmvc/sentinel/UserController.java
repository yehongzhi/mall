package io.github.yehongzhi.springmvc.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import io.github.yehongzhi.springmvc.model.User;
import io.github.yehongzhi.springmvc.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name UserController
 * @date 2021-03-25 01:41
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    public static final String RESOURCE_NAME = "userList";

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public List<User> getUserList() {
        List<User> userList = null;
        Entry entry = null;
        try {
            entry = SphU.entry(RESOURCE_NAME);
            userList = userService.getList();
        } catch (BlockException e) {
            //资源访问阻止，被限流或被降级
            return Collections.singletonList(new User("xxx", "资源访问被限流", 0));
        } catch (Exception e) {
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(e, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return userList;
    }

    public static final String RESOURCE_NAME_QUERY_USER_BY_ID = "queryUserById";


    @RequestMapping("/get/{id}")
    public String queryUserById(@PathVariable("id") String id) {
        if (SphO.entry(RESOURCE_NAME_QUERY_USER_BY_ID)) {
            try {
                //被保护的逻辑
                //模拟数据库查询数据
                return JSONObject.toJSONString(new User(id, "Tom", 25));
            } finally {
                //关闭资源
                SphO.exit();
            }
        } else {
            //资源访问阻止，被限流或被降级
            return "Resource is Block!!!";
        }
    }

    @RequestMapping("/getUser")
    public User queryUserByUserName(@RequestParam(name = "userName") String userName) {
        return userService.queryByUserName(userName);
    }

}
