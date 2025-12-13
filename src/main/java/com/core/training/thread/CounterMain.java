package com.core.training.thread;

/**
 * @Author huangyulu
 * @Date 2025/12/13 16:12
 * @Description
 */
public class CounterMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getCount());




    }
}


class Counter {
    private int count = 0;

 /*   public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }*/

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}
