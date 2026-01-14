package com.core.training.jucLearn;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author huangyulu
 * @Date 2026/1/10 14:52
 * @Description 读写锁，只允许一个线程写入，写入的时候其他线程既不能写也不能读；没有写入的时候，多个线程允许同时读（提高性能）
 */
public class ReadWriteLockDemo {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    private int value;


    public void write(int value) {
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " write=" + value);
            this.value = value;
        } finally {
            writeLock.unlock();
        }
    }

    public Integer read() {
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " read=" + value);
            return value;
        } finally {
            readLock.unlock();
        }
    }




    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Random random = new Random();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(200), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 3; i++) {
            pool.execute(() -> {
                demo.read();
            });
        }

        for (int i = 0; i < 2; i++) {
            pool.execute(() -> {
                demo.write(random.nextInt(100));
            });
        }

        pool.shutdown();



    }
}
