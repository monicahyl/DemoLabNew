package com.core.training.thread.synchronizeddemo;

/**
 * @Author huangyulu
 * @Date 2025/12/15 16:47
 * @Description 验证synchronized 可重入性
 */
public class SynchronizedReentrantDemo {

    public static void main(String[] args) throws InterruptedException {
        CounterSyncReentrant reentrant = new CounterSyncReentrant();

        Thread thread1 = new Thread(reentrant::increment);
        Thread thread2 = new Thread(reentrant::increment);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(reentrant.getCount());

    }
}


class CounterSyncReentrant {
    private int count = 0;

    // 1.synchronized 修饰实例方法
    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " start ");
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        methodB();
        System.out.println(Thread.currentThread().getName() + " end ");
    }

    public synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " methodB ");
    }

    public synchronized int getCount() {
        return count;
    }

}
