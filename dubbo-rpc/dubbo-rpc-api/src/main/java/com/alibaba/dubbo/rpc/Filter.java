package com.alibaba.dubbo.rpc;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:33
 */
@SPI
public interface Filter {

    Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException;
}
