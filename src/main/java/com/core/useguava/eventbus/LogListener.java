package com.core.useguava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @Author huangyulu
 * @Date 2026/1/16 17:58
 * @Description
 */
public class LogListener {

    @Subscribe
    public void onUserRegister(UserRegisterEvent event) {
        System.out.println("记录用户注册日志：" + event.getUsername());
    }
}
