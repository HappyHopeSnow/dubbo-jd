package com.jd.dubbo.common.extension;

import java.lang.annotation.*;

/**
 * Description: <br>
 * 生成Extension的Adaptive instance 时，为ExtensionLoader提供信息
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/26 14:58
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Adaptive {
    String[] value() default {};
}
