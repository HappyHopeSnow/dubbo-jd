package com.alibaba.dubbo.rpc;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:31
 */
@SPI
public interface ExporterListener {

    void exported(Exporter<?> exporter) throws RpcException;

    void unexported(Exporter<?> exporter);
}
