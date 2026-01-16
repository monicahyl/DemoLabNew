package com.core.designpattern.Observer;

/**
 * @Author huangyulu
 * @Date 2026/1/16 16:15
 * @Description
 */
public class StockObsever implements Observer {
    @Override
    public void update(String event) {
        System.out.println("扣减库存：" + event);
    }
}
