package com.core.useguava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @Author huangyulu
 * @Date 2026/1/16 17:53
 * @Description
 */
public class EventBusBase {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        // 注册监听者
        eventBus.register(new EmailListener());
        eventBus.register(new LogListener());

        // 发布事件
        eventBus.post(new UserRegisterEvent("Monica"));



    }
}
