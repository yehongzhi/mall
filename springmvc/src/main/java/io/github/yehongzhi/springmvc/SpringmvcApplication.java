package io.github.yehongzhi.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
public class SpringmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);
    }

}
