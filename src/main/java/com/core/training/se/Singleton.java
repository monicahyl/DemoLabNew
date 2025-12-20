package com.core.training.se;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangyulu
 * @Date 2025/12/19 10:52
 * @Description 单例模式 - 懒汉式
 *
 * 线程不安全，多线程下可能创建多个实例
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                Singleton singleton = Singleton.getInstance();
                System.out.println(singleton);
            });
        }

        pool.shutdown();

    }

}
