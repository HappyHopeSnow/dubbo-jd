package com.jd.dubbo.common.logger;

/**
 * Description: <br>
 * 日志接口
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/21 19:58
 */
public interface Logger {

    /*trace*/
    void trace(String msg);

    void trace(Throwable e);

    void trace(String msg, Throwable e);


    /*debug*/
    void debug(String msg);

    void debug(Throwable e);

    void debug(String msg, Throwable e);

    /*info*/
    void info(String msg);

    void info(Throwable e);

    void info(String msg, Throwable e);

    /*warn*/
    void warn(String msg);

    void warn(Throwable e);

    void warn(String msg, Throwable e);

    /*error*/
    void error(String msg);

    void error(Throwable e);

    void error(String msg, Throwable e);

    /*分割*/

    boolean isTraceEnabled();

    boolean isDebugEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    boolean isErrorEnabled();


}
