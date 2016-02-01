package com.jd.dubbo.common;

import java.lang.annotation.*;

/**
 * Description: <br>
 * 扩展点接口的标识
 * 扩展点声明配置文件，格式修改
 * 以protocol示例：配置文件
 * META-INF/dubbo/com.jd.Protocol内容
 * 原因：<br/>
 * 当扩展点的static字段或方法签名上引用了三方库，
 * 如果三方库不存在，会导致类初始化失败，
 * Extension标识Dubbo就拿不到了，异常信息就和配置对应不起来。
 * <br/>
 * 比如:
 * Extension("mina")加载失败，
 * 当用户配置使用mina时，就会报找不到扩展点，
 * 而不是报加载扩展点失败，以及失败原因。
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/27 20:29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Extension {
    String value() default "";
}
