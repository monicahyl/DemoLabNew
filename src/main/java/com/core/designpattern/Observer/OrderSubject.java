package com.core.designpattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangyulu
 * @Date 2026/1/16 16:12
 * @Description 同步阻塞实现方式
 */
public class OrderSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void pay() {
        System.out.println("订单支付成功");
        notifyObservers("PAID");
    }
}
