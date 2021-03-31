package io.github.yehongzhi.user.redisLock;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name CustomerThread
 * @date 2021-02-21 13:41
 **/
public class CustomerThread implements Runnable {

    public static int count = 1000;

    @Override
    public void run() {
        count = count - 2;
    }
}
