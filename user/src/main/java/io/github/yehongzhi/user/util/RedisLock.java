package io.github.yehongzhi.user.util;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name RedisLock
 * @date 2021-02-21 13:25
 **/
public class RedisLock {

    private static Jedis jedis = new Jedis("127.0.0.1");

    private static final Long SUCCESS = 1L;

    /**
     * 加锁
     */
    public boolean tryLock(String key, String requestId, int expireTime) {
        //使用jedis的api，保证原子性
        //NX 不存在则操作 EX 设置有效期，单位是秒
        String result = jedis.set(key, requestId, "NX", "EX", expireTime);
        //返回OK则表示加锁成功
        return "OK".equals(result);
    }

    //删除key的lua脚本，先比较requestId是否相等，相等则删除
    private static final String DEL_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    /**
     * 解锁
     */
    public boolean unLock(String key, String requestId) {
        //删除成功表示解锁成功
        Long result = (Long) jedis.eval(DEL_SCRIPT, Collections.singletonList(key), Collections.singletonList(requestId));
        return SUCCESS.equals(result);
    }
}
