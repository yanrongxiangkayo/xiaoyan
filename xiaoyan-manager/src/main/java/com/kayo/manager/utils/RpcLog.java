package com.kayo.manager.utils;

import java.lang.annotation.*;

/**
 * @author yanrx
 * @version 1.0
 * @date 2021/6/27 14:19
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcLog {
    String id() default "";

    String name() default "";
}
