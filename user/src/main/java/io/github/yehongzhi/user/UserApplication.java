package io.github.yehongzhi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UserApplication {
/*
* nohup java -jar user-0.0.1-SNAPSHOT.jar  > log.file  2>&1 &
* jmap -dump:format=b,file=user.dump 1300
* http://192.168.0.109:8601/mall/user/list
* */
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
