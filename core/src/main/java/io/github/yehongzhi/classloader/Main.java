package io.github.yehongzhi.classloader;

import java.lang.reflect.Method;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name Main
 * @date 2020-09-03 23:13
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        String path = "D:\\mall\\core\\src\\main\\java\\io\\github\\yehongzhi\\classloader\\Hello.class";
        CustomerClassLoader classLoader = new CustomerClassLoader(path);
        Class<?> clazz = classLoader.findClass("io.github.yehongzhi.classloader.Hello");
        System.out.println("使用类加载器：" + clazz.getClassLoader());
        Method method = clazz.getDeclaredMethod("say");
        Object obj = clazz.newInstance();
        method.invoke(obj);
    }
}
