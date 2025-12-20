package com.core.training.concurrent;

/**
 * this逸出 + final失效
 */
public class ThisEscapeDemo {

    static ThisEscapeDemo globalObj;

    final int x;

    // 构造函数
    public ThisEscapeDemo() {
        x = 42;

        // 👇 关键：this 逸出
        globalObj = this;
    }

    public static void main(String[] args) throws Exception {

        // 线程 A：负责构造对象
        Thread t1 = new Thread(() -> {
            new ThisEscapeDemo();
        });

        // 线程 B：不断尝试读取对象
        Thread t2 = new Thread(() -> {
            while (true) {
                ThisEscapeDemo obj = globalObj;
                if (obj != null) {
                    // 理论上 final x 应该永远是 42
                    if (obj.x != 42) {
                        System.out.println("看到异常值 x = " + obj.x);
                        break;
                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}