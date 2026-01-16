package com.core.designpattern.Observer;

/**
 * @Author huangyulu
 * @Date 2026/1/16 16:09
 * @Description （被观察者 / 主题）
 *
 * 	•	状态的拥有者
 * 	•	负责：
 * 	•	保存观察者
 * 	•	状态变化时通知观察者
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String event);
}
