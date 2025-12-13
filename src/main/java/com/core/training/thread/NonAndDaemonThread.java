package com.core.training.thread;

/**
 * @Author huangyulu
 * @Date 2025/12/12 16:14
 * @Description
 */
public class NonAndDaemonThread {

    public static void main(String[] args) {
        System.out.println("main start");

        Thread thread = new Thread(() -> {
           while (true) {
//               try {
//                   Thread.sleep(100);
                   System.out.println(Thread.currentThread().getName() + " still alive");
//               } catch (InterruptedException e) {
//                   throw new RuntimeException(e);
//               }

           }
        });

        // set thread as a daemon thread
        thread.setDaemon(true);

        // start thread
        thread.start();
        System.out.println("main end");
    }

}

