package io.github.yehongzhi.base;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ZkLock
 * @date 2020-07-16 22:50
 **/
public class ZkLock implements Lock {

    //计数器，用于加锁失败时，阻塞
    private static CountDownLatch cdl = new CountDownLatch(1);

    //ZooKeeper服务器的IP端口
    private static final String IP_PORT = "127.0.0.1:2181";
    //锁的根路径
    private static final String ROOT_NODE = "/Lock";

    //上一个节点的路径
    private volatile String beforePath;

    //当前上锁的节点路径
    private volatile String currPath;

    private ZkClient zkClient = new ZkClient(IP_PORT);

    public ZkLock() {
        //判断是否存在根节点
        if (!zkClient.exists(ROOT_NODE)) {
            //不存在则创建
            zkClient.createPersistent(ROOT_NODE);
        }
    }

    public void lock() {
        if (tryLock()) {
            System.out.println("加锁成功！！");
        } else {
            // 尝试加锁失败，进入等待 监听
            waitForLock();
            // 再次尝试加锁
            lock();
        }

    }

    public synchronized boolean tryLock() {
        // 第一次就进来创建自己的临时节点
        if (StringUtils.isBlank(currPath)) {
            currPath = zkClient.createEphemeralSequential(ROOT_NODE + "/", "lock");
        }
        // 对节点排序
        List<String> children = zkClient.getChildren(ROOT_NODE);
        Collections.sort(children);

        // 当前的是最小节点就返回加锁成功
        if (currPath.equals(ROOT_NODE + "/" + children.get(0))) {
            return true;
        } else {
            // 不是最小节点 就找到自己的前一个 依次类推 释放也是一样
            int beforePathIndex = Collections.binarySearch(children, currPath.substring(ROOT_NODE.length() + 1)) - 1;
            beforePath = ROOT_NODE + "/" + children.get(beforePathIndex);
            //返回加锁失败
            return false;
        }
    }

    public void unlock() {
        //删除节点并关闭客户端
        zkClient.delete(currPath);
        zkClient.close();
    }

    private void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            //监听节点更新事件
            public void handleDataChange(String s, Object o) throws Exception {
            }

            //监听节点被删除事件
            public void handleDataDeleted(String s) throws Exception {
                //解除阻塞
                cdl.countDown();
            }
        };
        // 监听上一个节点
        this.zkClient.subscribeDataChanges(beforePath, listener);
        //判断上一个节点是否存在
        if (zkClient.exists(beforePath)) {
            //上一个节点存在
            try {
                System.out.println("加锁失败 等待");
                //加锁失败，阻塞等待
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(beforePath, listener);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public Condition newCondition() {
        return null;
    }
}
