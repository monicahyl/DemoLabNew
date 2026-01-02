package com.core.training.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author huangyulu
 * @Date 2026/1/1 21:33
 * @Description
 */
public class TestInterrupt {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    queue.put(i); // 阻塞操作，可被中断
                    System.out.println("Producer " + i);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted, exiting...");
//                Thread.currentThread().interrupt(); // 保留状态
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer take = queue.take(); // 阻塞操作，可被中断
                    System.out.println("Consumer " + take);
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted, exiting...");
//                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();


        producer.interrupt();
        consumer.interrupt();


    }
}
