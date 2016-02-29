package com.alibaba.dubbo.rpc;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:34
 */
@SPI
public interface InvokerListener {

    void referred(Invoker<?> invoker) throws RpcException;

    void destroyed(Invoker<?> invoker);
}
