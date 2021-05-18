package io.github.yehongzhi.user.user.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name UserController
 * @date 2020-09-23 23:55
 **/
@RestController
@RequestMapping("/mall/user")
public class UserController {

    @RequestMapping("/list")
    public Map<String, Object> list() throws Exception {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("1号佳丽", "李嘉欣");
        userMap.put("2号佳丽", "袁咏仪");
        userMap.put("3号佳丽", "张敏");
        userMap.put("4号佳丽", "张曼玉");
        return userMap;
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable(name = "id") String id) throws Exception {
        HashMap<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "关之琳");
        user.put("经典角色", "十三姨");
        return JSONObject.toJSONString(user);
    }

    private static Map<String, String> map = new HashMap<>();

    @RequestMapping("/oom")
    public String oom() throws Exception {
        for (int i = 0; i < 100000; i++) {
            map.put("key" + i, "value" + i);
        }
        return "oom";
    }
}
