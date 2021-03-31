package io.github.yehongzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * SpringBoot项目启动类
 *
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name MallApplication
 * @date 2020-07-11 23:54
 **/
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("io.github.yehongzhi.*.mapper")
public class MallApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MallApplication.class, args);
    }
}