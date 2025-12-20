package com.core.training.se;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangyulu
 * @Date 2025/12/19 14:10
 * @Description 饿汉式
 */
public class SingletonB {

//    private static SingletonB instance = new SingletonB();
    private static SingletonB instance;
//
    static {
        instance = new SingletonB();
    }

    private SingletonB() {

    }

    public static SingletonB getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 20; i++) {
            pool.execute(() -> {
                SingletonB singleton = SingletonB.getInstance();
                System.out.println(singleton);
            });
        }

        pool.shutdown();
    }
}
