package com.core.designpattern.Observer;

/**
 * @Author huangyulu
 * @Date 2026/1/16 16:17
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        OrderSubject orderSubject = new OrderSubject();

        MessageObserver messageObserver = new MessageObserver();
        orderSubject.registerObserver(messageObserver);
        StockObsever stockObsever = new StockObsever();
        orderSubject.registerObserver(stockObsever);

        orderSubject.pay();
    }
}
