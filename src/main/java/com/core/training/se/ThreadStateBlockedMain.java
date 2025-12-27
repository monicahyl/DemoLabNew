package com.core.training.se;

import java.net.InetAddress;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author huangyulu
 * @Date 2025/12/22 12:14
 * @Description
 */
public class ThreadStateBlockedMain {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
//            counter.increment();
//            counter.incr();

            // 调用阻塞API，JVM层面，非阻塞状态BLOCKED
//            InetAddress.getByName();
        });

        Thread t2 = new Thread(() -> {
//            counter.increment();
//            counter.incr();

//            InetAddress.getByName();
        });

        t1.start();
        t2.start();



        while (t1.isAlive() || t2.isAlive()) {
            System.out.println(t1.getName() + "的状态为： " + t1.getState());
            System.out.println(t2.getName() + "的状态为： " + t2.getState());
            Thread.sleep(1000);
        }

        t1.join();
        t2.join();

        System.out.println(counter.getCount());


        LockSupport.park();

    }
}
