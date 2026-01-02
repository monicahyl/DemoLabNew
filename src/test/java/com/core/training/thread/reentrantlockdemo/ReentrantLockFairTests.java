package com.core.training.thread.reentrantlockdemo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangyulu
 * @Date 2025/12/29 16:15
 * @Description
 */
public class ReentrantLockFairTests {

    @Test
    public void testLockFair() {
        ReentrantLockFair reentrantLockFair = new ReentrantLockFair();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.AbortPolicy());


        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                reentrantLockFair.lock();
            });
        }

        pool.shutdown();
    }
}
