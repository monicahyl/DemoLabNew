package com.core.web.config.anno;

import java.lang.annotation.*;

/**
 * @Author huangyulu
 * @Date 2026/1/10 17:37
 * @Description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {

    String name() default "";
}
