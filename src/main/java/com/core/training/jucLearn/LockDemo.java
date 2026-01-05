package com.core.training.jucLearn;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author huangyulu
 * @Date 2026/1/2 17:27
 * @Description
 */
public class LockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    }
}
