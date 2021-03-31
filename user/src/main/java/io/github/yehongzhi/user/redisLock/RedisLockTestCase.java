package io.github.yehongzhi.user.redisLock;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name RedisLockTestCase
 * @date 2021-02-21 13:38
 **/
public class RedisLockTestCase {

    public static void main(String[] args) throws Exception {

    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Object obj, Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        return t;
    }
}
