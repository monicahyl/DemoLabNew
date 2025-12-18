package com.core.training.thread.reentrantlockdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huangyulu
 * @Date 2025/12/15 18:23
 * @Description
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(counter::incrementInterruptibly);
        Thread t2 = new Thread(counter::incrementInterruptibly);

        t1.start();
        t2.start();

        t2.interrupt();



    }
}


class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    // 普通阻塞锁
    public void increment() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " start");
            count++;
            System.out.println(Thread.currentThread().getName() + " end");
        } finally {
            lock.unlock();
        }
    }


    // 可中断锁
    public void incrementInterruptibly() {
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + " start");
            count++;
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
