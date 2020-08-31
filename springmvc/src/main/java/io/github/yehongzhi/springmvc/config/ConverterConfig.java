package io.github.yehongzhi.springmvc.config;

import io.github.yehongzhi.springmvc.converter.StringToDateConverter;
import io.github.yehongzhi.springmvc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ConverterConfig
 * @date 2020-08-29 20:47
 **/
@Configuration
public class ConverterConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        //添加类型转换器
        registry.addConverter(new StringToDateConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**");
    }
}
