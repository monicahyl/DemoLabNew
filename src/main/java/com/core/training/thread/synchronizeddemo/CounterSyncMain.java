package com.core.training.thread.synchronizeddemo;

/**
 * @Author huangyulu
 * @Date 2025/12/13 16:12
 * @Description
 */
public class CounterSyncMain {


    public static void main(String[] args) throws InterruptedException {
        CounterSync counter = new CounterSync();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                counter.increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getCount());


    }


}




class CounterSync {
    private int count = 0;

    private final Object lock = new Object();

    // 1.synchronized 修饰代码块
    public void increment() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " start ");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " end ");
        }
    }

    public synchronized int getCount() {
        return count;
    }

}
