package com.core.training.thread.reentrantlockdemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huangyulu
 * @Date 2025/12/27 14:11
 * @Description ReentrantLock常用方法
 */
@Slf4j
public class ReentrantLockBase {

    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 获取锁，如果锁被占用就阻塞等待
     */
/*    public void lock() {
        try {
            lock.lock(); // lock不响应中断
            log.info("{} lock locked", Thread.currentThread().getName());
            Thread.sleep(1000); // sleep响应中断
        } catch (InterruptedException e) {
            log.error("{} ", Thread.currentThread().getName(), e.getMessage(), e);
        }finally {
            lock.unlock();
        }
    }*/

    public void lock() {
        try {
            lock.lock(); // lock不响应中断
            log.info("{} lock locked", Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }


    /**
     * 获取锁，但可以响应中断，如果被中断就会跑InterruptedException
     */
    public void lockInterruptibly() {
        try {
            lock.lockInterruptibly();
            log.info("{} lockInterruptibly locked", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            log.error("Thread {} error: {}", Thread.currentThread().getName(), e.getMessage(), e);
        } finally {
            // 如果线程在lockInterruptibly之前被中断，此处会抛异常IllegalMonitorStateException
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }

        }
    }

    /**
     * 线程尝试获取锁，如果锁空闲就获取成功，否则立即返回false（非阻塞）
     */
    public void tryLock() {
        if (lock.tryLock()) {
            log.info("{} tryLock locked", Thread.currentThread().getName());
            try {
                log.info("{} tryLock code", Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        } else {
            log.info("{} tryLock fail", Thread.currentThread().getName());
        }
    }

    /**
     * 线程尝试获取锁，如果锁空闲就获取成功，否则立即返回false（非阻塞）
     */
    public void tryLockTimeout() throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            log.info("{} tryLockTimeout locked", Thread.currentThread().getName());
            try {
                log.info("{} tryLockTimeout code", Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        } else {
            log.info("{} tryLockTimeout fail", Thread.currentThread().getName());
        }
    }






    public static void main(String[] args) throws InterruptedException {

        ReentrantLockBase lock = new ReentrantLockBase();



        Thread t1 = new Thread(() -> {
            lock.lock();
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();




    }
}
