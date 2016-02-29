package com.alibaba.dubbo.rpc;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:20
 */
@SPI("dubbo")
public interface Protocol {

    /**
     * 获取缺省端口，当用户没有配置端口时使用
     * @return
     */
    int getDefultPort();

    /**
     * 暴露服务
     * @param invoker
     * @param <T>
     * @return
     * @throws RpcException
     */
    @Adaptive
    <T> Exporter<T> export(Invoker<T> invoker) throws RpcException;

    /**
     * 引用远程服务
     * @param type
     * @param url
     * @param <T>
     * @return
     * @throws RpcException
     */
    @Adaptive
    <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException;

    /**
     * 释放协议
     */
    void destroy();
}
