package com.core.training.thread.reentrantlockdemo;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;

/**
 * @Author huangyulu
 * @Date 2025/12/27 16:41
 * @Description
 */
public class ReentrantLockBufferMoreTests {

    @Test
    public void testProduce() {
        ReentrantLockBufferMore lockBufferMore = new ReentrantLockBufferMore();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                int randomInt = RandomUtil.randomInt(10, 100);
                lockBufferMore.produce(randomInt);
            });
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                lockBufferMore.consume();
            });
            thread.start();
        }

    }
}
