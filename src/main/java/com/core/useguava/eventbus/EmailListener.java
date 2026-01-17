package com.core.useguava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @Author huangyulu
 * @Date 2026/1/16 17:56
 * @Description 邮件监听
 */
public class EmailListener {

    @Subscribe
    public void onUserRegister(UserRegisterEvent event) {
        System.out.println("发送注册成功邮件给用户：" + event.getUsername());
    }

}
