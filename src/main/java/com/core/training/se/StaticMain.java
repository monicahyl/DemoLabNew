package com.core.training.se;

/**
 * @Author huangyulu
 * @Date 2025/12/20 11:01
 * @Description
 */
public class StaticMain {
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(StaticMain.add(1, 2));

        StaticMain staticMain = new StaticMain();
        System.out.println(staticMain.add(1, 2));

    }
}
