package com.core.training.thread.synchronizeddemo;

/**
 * @Author huangyulu
 * @Date 2025/12/15 17:39
 * @Description 验证synchronized 不可中断
 */
public class SynchronizedInterruptDemo {

    public static void main(String[] args) {
        CounterSyncInterrupt demo = new CounterSyncInterrupt();

        Thread thread1 = new Thread(demo::increment);
        Thread thread2 = new Thread(demo::increment);
        thread1.start();
        thread2.start();

        thread2.interrupt();


    }
}


class CounterSyncInterrupt {

    // 1.synchronized 修饰实例方法
    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " start ");
        methodB();
        System.out.println(Thread.currentThread().getName() + " end ");
    }

    public synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " methodB ");
    }


}