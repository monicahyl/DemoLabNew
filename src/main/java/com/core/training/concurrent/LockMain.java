package com.core.training.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author huangyulu
 * @Date 2025/12/20 23:03
 * @Description
 */
public class LockMain {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }
}
