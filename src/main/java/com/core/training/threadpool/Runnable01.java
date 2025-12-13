package com.core.training.threadpool;

/**
 * @Author huangyulu
 * @Date 2025/12/12 15:05
 * @Description
 */
public class Runnable01 implements Runnable {

    public int taskId;

    public Runnable01() {

    }

    public Runnable01(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running task " + taskId);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
