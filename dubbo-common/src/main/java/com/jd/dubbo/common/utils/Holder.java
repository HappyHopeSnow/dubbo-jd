package com.jd.dubbo.common.utils;

/**
 * Description: <br>
 * 持有类的工具类-使用泛型
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/26 12:02
 */
public class Holder<T> {
    private volatile T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
