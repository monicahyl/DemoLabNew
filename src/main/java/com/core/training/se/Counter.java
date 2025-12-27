package com.core.training.se;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huangyulu
 * @Date 2025/12/22 12:14
 * @Description
 */
public class Counter {

    private int count;

    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        try {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Counter interrupted");
        }

    }

    public void incr() {
        lock.lock();

        try {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Counter interrupted");
        } finally {
            lock.unlock();
        }
    }

    public synchronized int getCount() {
        return count;
    }

}
