package com.core.training.thread;

import cn.hutool.core.util.RandomUtil;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author huangyulu
 * @Date 2026/1/6 19:35
 * @Description
 */
public class ThreadLocalDemo {


    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        threadLocal.set(1);


        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(200),
                new ThreadPoolExecutor.AbortPolicy()
        );

       for (int i = 0; i < 10; i++) {
           pool.execute(() -> {
               ThreadLocalRandom random = RandomUtil.getRandom();
               Integer i1 = threadLocal.get();
               threadLocal.set(i1 + random.nextInt(100));
           });
       }

       pool.shutdown();

        System.out.println(threadLocal.get());


    }

}
