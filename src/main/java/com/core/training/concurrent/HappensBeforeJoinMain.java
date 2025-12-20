package com.core.training.concurrent;

import com.core.training.se.FinalMain;

/**
 * @Author huangyulu
 * @Date 2025/12/20 10:10
 * @Description 验证Happens-Before规则中的 线程join()规则
 */
public class HappensBeforeJoinMain {

    private static int var = 0;



    public static void main(String[] args) throws InterruptedException {

        Thread threadB = new Thread(new Runnable() {
            public void run() {

                if (var == 77) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    var = 0;
                    System.out.println("main thread happens before threadB");
                }
            }
        });

        var = 77;

        threadB.start();
        threadB.join();

        System.out.println("var==" + var);


    }
}
