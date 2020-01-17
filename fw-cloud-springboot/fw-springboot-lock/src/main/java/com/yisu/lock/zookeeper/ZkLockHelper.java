package com.yisu.lock.zookeeper;

import lombok.NoArgsConstructor;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 *  zk  分布式锁
 * @Author xuyisu
 * @Date 2019/12/6
 */
@NoArgsConstructor
public class ZkLockHelper {

    private static String address = "localhost:2181";

    public static CuratorFramework client;

    static {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 1);
        client = CuratorFrameworkFactory.newClient(address, retryPolicy);
        client.start();
    }

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
    }

    /**
     * 获取分布式锁实例
     * @return
     */
    public static InterProcessMutex getMutex() {
        return SingletonHolder.mutex;
    }

    /**
     * 加锁
     * @param time
     * @param unit
     * @return
     */
    public static boolean lock(long time, TimeUnit unit) {
        try {
            return getMutex().acquire(time, unit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 解锁
     */
    public static void unlock() {
        try {
            getMutex().release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}  
