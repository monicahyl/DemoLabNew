package com.core.training.thread.synchronizeddemo;

/**
 * @Author huangyulu
 * @Date 2025/12/13 16:12
 * @Description
 */
public class CounterMain {

    /**
     * 修饰实例方法，同一个实例，互斥
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 1000; i++) {
                    counter.increment();
//                }
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



//    public static void main(String[] args) throws InterruptedException {
//        Counter counter1 = new Counter();
//        Counter counter2 = new Counter();
//
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
////                for (int i = 0; i < 1000; i++) {
//                    counter1.increment();
////                }
//            }
//        };
//
//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
////                for (int i = 0; i < 1000; i++) {
//                    counter2.increment();
////                }
//            }
//        };
//
//        Thread thread1 = new Thread(runnable1);
//        Thread thread2 = new Thread(runnable2);
//
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//
//        System.out.println(counter1.getCount());
//        System.out.println(counter2.getCount());
//
//    }
}


class Counter {
    private int count = 0;

    // 1.修饰实例方法
    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " increment start");
        count++;
        System.out.println(Thread.currentThread().getName() + " increment end");
    }


    public synchronized int getCount() {
        return count;
    }

}
