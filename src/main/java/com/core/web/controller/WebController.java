package com.core.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangyulu
 * @Date 2026/1/10 15:17
 * @Description
 */
@RestController
public class WebController {

    /*
    *
    * 数据源
    * 日志
    * 项目-心跳检测
    *
    * */
    @GetMapping("/health")
    public Map<String, Object> health(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "0");
        result.put("message", "OK");
        return result;
    }

}
