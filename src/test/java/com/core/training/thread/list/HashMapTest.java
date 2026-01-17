package com.core.training.thread.list;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author huangyulu
 * @Date 2026/1/16 11:57
 * @Description
 */
public class HashMapTest {

    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i, i);
        }

        for (int i = 1000; i < 2000; i++) {
            map.put(i, i);
        }

        System.out.println(map.size());


    }


    /**
     * 多线程环境下，向hashmap put数据，数据会丢失
     *
     * @throws InterruptedException
     */
    @Test
    public void testData() throws InterruptedException {
        Map<Integer, Integer> map = new HashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println(map.size());
    }

    @Test
    public void testConcurrentHashMap() throws InterruptedException {

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map.size());

    }

}
