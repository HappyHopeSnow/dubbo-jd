package com.jd.dubbo.common.extension;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/26 11:10
 */
@SPI
public interface ExtensionFactory {
    <T> T getExtension(Class<T> type, String name);
}
