package com.core.training.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangyulu
 * @Date 2026/1/10 13:54
 * @Description
 */
public class ArrayListDemo {

    private final List<Integer> list = new ArrayList<>(1000);

    public synchronized void add(int num) {
        list.add(num);
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayListDemo demo = new ArrayListDemo();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                demo.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                demo.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(demo.list.size());
    }


}
