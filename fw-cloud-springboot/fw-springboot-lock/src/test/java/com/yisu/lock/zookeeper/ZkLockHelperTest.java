package com.yisu.lock.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ZkLockHelperTest {


    @Test
    public void testDistributedLock() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    boolean flag = false;
                    try {
                        flag = ZkLockHelper.lock(1, TimeUnit.SECONDS);
                        if (flag) {
                            log.info("获取锁成功,{}" , Thread.currentThread().getName());
                        } else {
                            log.info("获取锁失败,{}" , Thread.currentThread().getName());
                        }
                        //延时4秒
                        Thread.sleep(4000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (flag) {
                            try {
                                ZkLockHelper.unlock();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

        }
        try {
            fixedThreadPool.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}