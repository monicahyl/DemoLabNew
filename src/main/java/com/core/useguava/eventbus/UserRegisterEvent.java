package com.core.useguava.eventbus;

/**
 * @Author huangyulu
 * @Date 2026/1/16 17:55
 * @Description 用户注册事件
 */
public class UserRegisterEvent {

    private String username;

    public UserRegisterEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
