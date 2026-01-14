package com.core.training.jucLearn;

import java.util.concurrent.Semaphore;

/**
 * @Author huangyulu
 * @Date 2026/1/10 14:47
 * @Description
 */
public class SemaphoreLimit {

    private final Semaphore semaphore = new Semaphore(3);


    public void access() {
        try {
            semaphore.acquire();

            // todo
            System.out.println(Thread.currentThread().getName() + " acquired");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }


    }

    public static void main(String[] args) {
        SemaphoreLimit semaphoreLimit = new SemaphoreLimit();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                semaphoreLimit.access();
            }).start();
        }



    }
}
