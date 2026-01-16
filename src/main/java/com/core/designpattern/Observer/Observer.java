package com.core.designpattern.Observer;

/**
 * @Author huangyulu
 * @Date 2026/1/16 16:04
 * @Description 观察者
 *
 * 	•	对变化感兴趣
 * 	•	收到通知后做自己的事
 */
public interface Observer {

    void update(String event);

}
