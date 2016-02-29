package com.alibaba.dubbo.rpc;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 8:59
 */
public interface Exporter<T> {

    Invoker<T> getInvoker();

    void unexport();
}
