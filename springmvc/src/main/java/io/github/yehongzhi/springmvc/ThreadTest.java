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

    private static ExecutorService executor;

    static {
        executor = new ThreadPoolExecutor(2, Runtime.getRuntime().availableProcessors() + 1, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
    }
    private static Object monitor = new Object();

    public static void main(String[] args) throws Exception {
        synchronized (monitor){

        }
    }

    //修饰一个方法
    public synchronized void doSome(){

    }

    //修饰一个方法
    public synchronized static void add(){

    }
}
