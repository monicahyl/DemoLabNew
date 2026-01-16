package com.core.designpattern.Observer;

/**
 * @Author huangyulu
 * @Date 2026/1/16 16:15
 * @Description
 */
public class MessageObserver implements Observer {
    @Override
    public void update(String event) {
        System.out.println("发送消息：" + event);
    }
}
