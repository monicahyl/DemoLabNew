package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author huangyulu
 * @Date 2025/3/9 21:35
 * @Description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoLabNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoLabNewApplication.class, args);
    }
}
