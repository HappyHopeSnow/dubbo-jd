package com.alibaba.dubbo.rpc;

import java.util.Map;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:17
 */
public interface Invocation {

    String getMethodName();

    Class<?>[] getParameterTypes();

    Object[] getArguments();

    Map<String, String> getAttachments();

    String getAttachment(String key);

    String getAttachment(String key, String defaultValue);

    Invoker<?> getInvoker();
}
