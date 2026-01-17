package com.core.designpattern.Observer.in;


import org.apache.commons.lang3.StringUtils;

/**
 * @Author huangyulu
 * @Date 2026/1/16 17:30
 * @Description
 */
public class UserController {

    private PromotionService promotionService;
    private UserService userService;

    public Long register(String phone, String password) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            // error msg
            return null;
        }

        // 用户注册，注册成功后发送优惠券
        Long userId = userService.register(phone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }

}
