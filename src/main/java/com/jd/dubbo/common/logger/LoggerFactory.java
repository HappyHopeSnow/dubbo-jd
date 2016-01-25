package com.jd.dubbo.common.logger;

import com.jd.dubbo.common.logger.support.FailsafeLogger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.*;

/**
 * Description: <br>
 * 日志输出工厂
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/21 19:58
 */
public class LoggerFactory {

    private LoggerFactory() {}

    private static volatile LoggerAdaptor LOGGER_ADAPTER;

    private static final ConcurrentMap<String, FailsafeLogger> LOGGERS = new ConcurrentHashMap<String, FailsafeLogger>();

    //查找常用的日志框架
    static {
        String logger = System.getProperty("dubbo.application.logger");
        if ("slf4j".equals(logger)) {
            setLoggerAdaptor(new Slf4jLoggerAdaptor());
        }else if("jcl".equals(logger)) {
            setLoggerAdaptor(new JclLoggerAdaptor());
        }else if ("log4j".equals(logger)) {
            setLoggerAdaptor(new Log4jLoggerAdaptor());
        }else if ("jdk".equals(logger)) {
            setLoggerAdaptor(new JdkLoggerAdaptor());
        } else {
            try {
                setLoggerAdaptor(new Log4jLoggerAdaptor());
            } catch (Throwable e1) {
                try {
                    setLoggerAdaptor(new Slf4jLoggerAdaptor());
                }catch (Throwable e2) {
                    try {
                        setLoggerAdaptor(new JclLoggerAdaptor());
                    }catch (Throwable e3) {
                        setLoggerAdaptor(new JdkLoggerAdaptor());
                    }
                }
            }
        }
    }

    public static void setLoggerAdapter(LoggerAdaptor loggerAdapter) {
        if (loggerAdapter != null) {
            Logger logger = loggerAdapter.getLogger(LoggerFactory.class.getName());
            logger.info("using logger: " + loggerAdapter.getClass().getName());
            LoggerFactory.LOGGER_ADAPTER = loggerAdapter;
            for(Map.Entry<String, FailsafeLogger> entry : LOGGERS.entrySet()) {
                e
            }
        }

    }

}
