package io.github.yehongzhi.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name StringToDateConverter
 * @date 2020-08-29 20:42
 **/
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //String转换成Date类型
            return sdf.parse(source);
        } catch (Exception e) {
            //类型转换错误
            e.printStackTrace();
        }
        return null;
    }
}
