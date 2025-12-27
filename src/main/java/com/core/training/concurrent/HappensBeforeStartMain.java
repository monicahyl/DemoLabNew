package com.core.training.concurrent;

/**
 * @Author huangyulu
 * @Date 2025/12/20 10:10
 * @Description 验证Happens-Before规则中的 线程start()规则
 */
public class HappensBeforeStartMain {

    private static int var = 0;

    public static void main(String[] args) {
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                if (var == 77) {
                    System.out.println("main thread happens before threadB");
                }
            }
        });

        var = 77;

        threadB.start();




    }
}
