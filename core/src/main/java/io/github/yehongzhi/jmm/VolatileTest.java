package io.github.yehongzhi.jmm;

import java.util.Vector;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name VolatileTest
 * @date 2020-09-17 22:19
 **/
public class VolatileTest extends Thread {

    private static volatile int count = 0;

    public static void main(String[] args) throws Exception {
        Vector<Thread> threads = new Vector<>();
        for (int i = 0; i < 100; i++) {
            VolatileTest thread = new VolatileTest();
            threads.add(thread);
            thread.start();
        }
        //等待子线程全部完成
        for (Thread thread : threads) {
            thread.join();
        }
        //输出结果，正确结果应该是1000，实际却。。。
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                //休眠500毫秒
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            add();
        }
    }

    private static synchronized void add() {
        count++;
    }

    private static volatile int a;
    private static volatile int b;
    private static volatile int k;

    private void hello() {
        a = 1;  //语句1
        b = 2;  //语句2
        k = 3;  //语句3
        a = 4;  //语句4
        b = 5;  //语句5
    }
}
