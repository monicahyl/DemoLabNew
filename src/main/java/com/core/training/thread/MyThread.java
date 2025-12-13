package com.core.training.thread;

/**
 * @Author huangyulu
 * @Date 2025/12/13 10:32
 * @Description
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " sleep begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " sleep end");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " sleep interrupted");
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + " do something");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        // 重复调用start方法会发生什么？ -> 抛异常，IllegalThreadStateException
//        myThread.start();

        // 验证子线程休眠期，被中断，抛异常 InterruptedException
        myThread.interrupt();



    }
}
