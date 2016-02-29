package com.alibaba.dubbo.rpc;

import java.util.Map;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:14
 */
public interface Result {

    Object getValue();

    Throwable getException();

    boolean hasException();

    Object recreate() throws Throwable;

    @Deprecated
    Object getResult();

    Map<String, String> getAttachments();

    String getAttachments(String key);

    String getAttachments(String key, String defaultValue);

}
