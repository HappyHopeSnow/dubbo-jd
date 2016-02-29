package com.alibaba.dubbo.config.support;

import java.lang.annotation.*;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/16 14:54
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Parameter {
    String key() default "";
    boolean required() default false;
    boolean excluded() default false;
    boolean escaped() default false;
    boolean attribute() default false;
    boolean append() default false;
}
