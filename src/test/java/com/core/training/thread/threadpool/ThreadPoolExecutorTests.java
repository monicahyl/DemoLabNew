package com.core.training.thread.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @Author huangyulu
 * @Date 2025/12/27 22:20
 * @Description
 */
public class ThreadPoolExecutorTests {

    @Test
    public void test() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
                10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        BlockingQueue<Integer> integers = new ArrayBlockingQueue<>(5);


    }
}
