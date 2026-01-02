package com.core.training.thread.synchronizeddemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author huangyulu
 * @Date 2025/12/30 14:36
 * @Description
 */
public class OptLockDemo {


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int count = 0;


    public int incrementAndGet() {
        return atomicInteger.incrementAndGet();
    }

    public int increment() {
       return count++;
    }

    public int get() {
        return atomicInteger.get();
    }

    public int getCount() {
        return count;
    }




    public static void main(String[] args) {

        OptLockDemo optLockDemo = new OptLockDemo();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                optLockDemo.incrementAndGet();
                optLockDemo.increment();
            });
        }

        pool.shutdown();

        System.out.println(optLockDemo.get());
        System.out.println(optLockDemo.getCount());

    }

}
