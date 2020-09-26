package io.github.yehongzhi.usernacos.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name UserController
 * @date 2020-09-25 22:47
 **/
@RestController
@RequestMapping("/mall/userNacos")
public class UserController {

    @RequestMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("周杰伦", "爱在西元前");
        userMap.put("张学友", "只想一生跟你走");
        userMap.put("刘德华", "忘情水");
        userMap.put("陈奕迅", "K歌之王");
        userMap.put("卫兰", "就算世界没有童话");
        return userMap;
    }
}
