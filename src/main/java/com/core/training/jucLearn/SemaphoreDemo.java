package com.core.training.jucLearn;

import java.util.concurrent.Semaphore;

/**
 * @Author huangyulu
 * @Date 2026/1/2 17:21
 * @Description
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {

            try {
                semaphore.acquire();
                Thread thread = new Thread(() -> {
                    System.out.println("hello " + Thread.currentThread().getName());
                });
                thread.setName("thread-" + i);
                thread.start();

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        }
    }


}
