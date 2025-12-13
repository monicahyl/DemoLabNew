package com.core.training.thread;

/**
 * @Author huangyulu
 * @Date 2025/12/12 17:48
 * @Description
 */
public class MyRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " do something");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        // 创建多个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new MyRunnable()).start();
        }
    }

}
