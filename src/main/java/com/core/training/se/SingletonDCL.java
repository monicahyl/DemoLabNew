package com.core.training.se;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangyulu
 * @Date 2025/12/19 14:22
 * @Description 单例模式 - 利用双重检查创建单例对象
 */
public class SingletonDCL {
    private static SingletonDCL instance;
    private SingletonDCL() {

    }

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 20; i++) {
            pool.execute(() -> {
                SingletonDCL singleton = SingletonDCL.getInstance();
                System.out.println(singleton);
            });
        }

        pool.shutdown();
    }


}
