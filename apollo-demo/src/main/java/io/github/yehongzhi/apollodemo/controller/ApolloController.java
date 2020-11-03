package io.github.yehongzhi.apollodemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ApolloController
 * @date 2020-10-18 22:03
 **/
@RestController
public class ApolloController {

    //冒号后面的是默认值
    @Value("${configValue:default}")
    private String configValue;

    @RequestMapping("/apollo/getConfig")
    public String getConfig() {
        return configValue;
    }
}
