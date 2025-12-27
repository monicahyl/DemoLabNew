package com.core.training.thread.reentrantlockdemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * by chartgpt
 */
public class InterruptibleProducerConsumer {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 3;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void produce(int data) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println(Thread.currentThread().getName() + " waiting to produce...");
                notFull.await();
            }
            queue.add(data);
            System.out.println(Thread.currentThread().getName() + " produced: " + data);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        boolean interrupted = false;
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " waiting to consume...");
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted during await");
                    interrupted = true;
                    // 保留中断状态
                    Thread.currentThread().interrupt();
                }
            }
            int data = queue.poll();
            System.out.println(Thread.currentThread().getName() + " consumed: " + data);
            notFull.signalAll();
        } finally {
            lock.unlock();
        }

        // 可以在锁释放后，再处理中断逻辑
        if (interrupted) {
            System.out.println(Thread.currentThread().getName() + " handling interrupt after releasing lock");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptibleProducerConsumer buffer = new InterruptibleProducerConsumer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " producer interrupted");
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " consumer sleep interrupted");
                }
            }
        }, "Consumer");

        producer.start();
        consumer.start();

        // 主线程休眠一段时间，然后中断消费者
        Thread.sleep(2000);
        System.out.println("Main thread interrupts Consumer");
        consumer.interrupt();

        producer.join();
        consumer.join();
    }
}