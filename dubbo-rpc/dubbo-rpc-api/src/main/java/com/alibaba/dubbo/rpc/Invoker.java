package com.alibaba.dubbo.rpc;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:13
 */
public interface Invoker<T> extends Node {

    Class<T> getInterface();
    Result invoke(Invocation invocation);
}
