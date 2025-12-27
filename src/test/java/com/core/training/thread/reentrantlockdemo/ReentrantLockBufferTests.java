package com.core.training.thread.reentrantlockdemo;

import org.junit.jupiter.api.Test;

/**
 * @Author huangyulu
 * @Date 2025/12/27 16:08
 * @Description
 */
public class ReentrantLockBufferTests {

    @Test
    public void testProduce() throws InterruptedException {
        ReentrantLockBuffer lockBuffer = new ReentrantLockBuffer();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lockBuffer.produce(10);
        });

        Thread t2 = new Thread(() -> {
            lockBuffer.consume();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }


}
