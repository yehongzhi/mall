package io.github.yehongzhi.springmvc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ThreadTest
 * @date 2020-11-17 23:33
 **/
public class ThreadTest {

    public static void main(String[] args) throws Exception {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            s.append(i);
        }
        System.out.println(s.toString());
    }
}
