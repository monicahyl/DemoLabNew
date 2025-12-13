package com.core.training.thread;

/**
 * @Author huangyulu
 * @Date 2025/12/13 15:39
 * @Description
 */
public class ThreadSynchronized extends Thread {

    public static int num = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        ThreadSynchronized t1 = new ThreadSynchronized();
        ThreadSynchronized t2 = new ThreadSynchronized();
        t1.start();
        t2.start();

    }

}
