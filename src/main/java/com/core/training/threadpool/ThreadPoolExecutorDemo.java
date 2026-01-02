package com.core.training.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangyulu
 * @Date 2025/12/27 22:06
 * @Description
 */
@Slf4j
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 10,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("{} run", Thread.currentThread().getName());
            });
        }




//        pool.shutdown();
        pool.shutdownNow();
    }
}
