package io.github.yehongzhi.user.user.controller;

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
}
