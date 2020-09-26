package io.github.yehongzhi.ordernacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrdernacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdernacosApplication.class, args);
    }

}
