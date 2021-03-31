package io.github.yehongzhi.springmvc.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.github.yehongzhi.springmvc.model.User;
import io.github.yehongzhi.springmvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name UserServiceImpl
 * @date 2021-03-16 00:56
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "周慧敏", 18));
        userList.add(new User("2", "关之琳", 20));
        userList.add(new User("3", "王祖贤", 21));
        return userList;
    }

    public static final String RESOURCE_NAME_QUERY_USER_BY_NAME = "queryUserByUserName";

    @Override
    @SentinelResource(value = RESOURCE_NAME_QUERY_USER_BY_NAME, blockHandler = "queryUserByUserNameBlock", fallback = "queryUserByUserNameFallBack")
    public User queryByUserName(String userName) {
        if (userName == null || "".equals(userName)) {
            //抛出异常
            throw new RuntimeException("queryByUserName() command failed, userName is null");
        }
        return new User("0", userName, 18);
    }

    public User queryUserByUserNameBlock(String userName, BlockException ex) {
        ex.printStackTrace();
        return new User("xxx", "用户名称：{" + userName + "},资源访问被限流", 0);
    }

    public User queryUserByUserNameFallBack(String userName, Throwable ex) {
        ex.printStackTrace();
        return new User("-1", "用户名称：{" + userName + "},系统异常，请稍后重试", 0);
    }
}
