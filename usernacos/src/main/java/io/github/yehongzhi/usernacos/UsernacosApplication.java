package io.github.yehongzhi.usernacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsernacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsernacosApplication.class, args);
    }

}
