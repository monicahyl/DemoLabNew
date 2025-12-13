package com.core.training.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author huangyulu
 * @Date 2025/12/12 17:41
 * @Description
 */
public class MyCallableMain {

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();

        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();

        try {
            Integer i = futureTask.get();
            System.out.println(i);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }




    }
}
