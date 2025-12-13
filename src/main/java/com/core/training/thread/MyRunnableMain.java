package com.core.training.thread;

/**
 * @Author huangyulu
 * @Date 2025/12/12 17:49
 * @Description
 */
public class MyRunnableMain {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();
    }
}
