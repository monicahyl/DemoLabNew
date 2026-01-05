package com.core.training.thread.reentrantlockdemo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangyulu
 * @Date 2025/12/27 14:24
 * @Description
 */
public class ReentrantLockBaseTests {


    @Test
    void testLock() throws InterruptedException {
        ReentrantLockBase lock = new ReentrantLockBase();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.lock();
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
        });

        t1.start();
        t2.start();

        // lock(),不响应中断
        t2.interrupt();

        t1.join();
        t2.join();

    }

    @Test
    void testLockInterruptibly() throws InterruptedException {
        ReentrantLockBase lock = new ReentrantLockBase();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.lockInterruptibly();
        });

        Thread t2 = new Thread(() -> {
            lock.lockInterruptibly();
        });

        t1.start();
        t2.start();
        // lockInterruptibly()，响应中断
        t2.interrupt();

        t1.join();
        t2.join();

    }

    @Test
    public void tryLock() {
        ReentrantLockBase lock = new ReentrantLockBase();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 3; i++) {
            poolExecutor.execute(() -> {
//                        lock.tryLock();

                        try {
                            lock.tryLockTimeout();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }

        poolExecutor.shutdown();

    }

}
