package com.core.training.concurrent;

/**
 * @Author huangyulu
 * @Date 2025/12/18 15:56
 * @Description 并发编程问题：可见性问题
 */
public class CounterMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            counter.increment();
        });
        Thread t2 = new Thread(() -> {
            counter.increment();
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());


    }
}


class Counter {
    private volatile int count = 0;


    public void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
