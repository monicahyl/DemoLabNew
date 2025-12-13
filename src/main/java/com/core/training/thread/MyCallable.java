package com.core.training.thread;

import java.util.concurrent.Callable;

/**
 * @Author huangyulu
 * @Date 2025/12/12 17:36
 * @Description
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        return sum;

    }
}
