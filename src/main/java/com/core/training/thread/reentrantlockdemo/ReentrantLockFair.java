package com.core.training.thread.reentrantlockdemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huangyulu
 * @Date 2025/12/29 16:13
 * @Description ReentrantLock 公平锁
 */
@Slf4j
public class ReentrantLockFair {


    // 构造参数，true设置为公平锁，默认是非公平锁
//    private final ReentrantLock lock = new ReentrantLock(true);
    private final ReentrantLock lock = new ReentrantLock();

    public void lock() {
        try {
            lock.lock();

            log.info("{} get lock", Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }

    }


}
