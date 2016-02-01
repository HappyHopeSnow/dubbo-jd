package com.jd.dubbo.common.extension;

import java.lang.annotation.*;

/**
 * Description: <br>
 * 扩展点接口的标识
 * 扩展点标识声明配置文件，格式修改
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/22 14:37
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI {

    /**
     * 缺省扩展点名。
     * @return
     */
    String value() default "";
}
