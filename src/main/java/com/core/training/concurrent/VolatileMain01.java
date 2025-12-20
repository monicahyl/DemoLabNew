package com.core.training.concurrent;

/**
 * @Author huangyulu
 * @Date 2025/12/18 16:31
 * @Description
 */
public class VolatileMain01 {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (flag) {

            }
            System.out.println("thread end");
        });

        Thread.sleep(1000);
        flag = false;

    }
}
