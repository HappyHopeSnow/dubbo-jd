package com.jd.dubbo.common.extension;

import java.lang.annotation.*;

/** Activate ：激活
 * Description: <br>
 * 对于可以被框架中自动激活加载扩展，此Annotation用于配置扩展被自动激活加载条件
 * 比如：过滤扩展，有多个实现，使用Activate Annotation的扩展可以根据条件被自动加载。
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/26 12:04
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Activate {

    String[] group() default {};
    String[] value() default {};
    String[] before() default {};
    String[] after() default {};
    int order() default 0;
}
