package com.core.training.thread.reentrantlockdemo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huangyulu
 * @Date 2025/12/27 16:27
 * @Description
 */
@Slf4j
public class ReentrantLockBufferMore {

    private List<Integer> list = new ArrayList(3);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition(); // 队列非空可消费
    private final Condition notFull = lock.newCondition(); // 队列未满可生产


    /**
     * 生产者三个条件：
     * 队列空，生产
     * 队列满，如何处理？抛弃？阻塞？
     *
     * @param data
     */
    public void produce(int data) {
        try {
            lock.lock();
            log.info("produce lock");
            while (list.size() == 3) {
                log.info("produce await");
                notFull.await();
            }
            list.add(data);
            log.info("{} Produced data: {}", Thread.currentThread().getName(), data);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            log.error("{} produce InterruptedException", Thread.currentThread().getName(), e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lock();
            log.info("consume lock");
            while (list.isEmpty()) {
                log.info("consume await");
//                notEmpty.await();
                notEmpty.await(1, TimeUnit.MILLISECONDS);
            }
            Integer remove = list.remove(list.size() - 1);
            log.info("{} consumed data={}", Thread.currentThread().getName(), remove);


            notFull.signalAll();
        } catch (InterruptedException e) {
            log.error("{} consume InterruptedException", Thread.currentThread().getName(), e.getMessage(), e);
        } finally {
            lock.unlock();
        }

    }


}
