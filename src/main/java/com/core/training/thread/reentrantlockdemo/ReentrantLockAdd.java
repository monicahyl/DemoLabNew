package com.core.training.thread.reentrantlockdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huangyulu
 * @Date 2026/1/10 13:22
 * @Description
 */
public class ReentrantLockAdd {


    private final ReentrantLock lock = new ReentrantLock();

    int value = 0;

    public void add() {
        try {
            lock.lock();
            value+=1;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockAdd add = new ReentrantLockAdd();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    add.add();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    add.add();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(add.value);
    }


}
