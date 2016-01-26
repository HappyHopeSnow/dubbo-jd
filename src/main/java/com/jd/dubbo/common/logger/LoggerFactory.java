package com.jd.dubbo.common.logger;

import com.jd.dubbo.common.logger.support.FailsafeLogger;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Description: <br>
 * 日志输出工厂
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/21 19:58
 */
public class LoggerFactory {

    private LoggerFactory() {}

    private static volatile LoggerAdapter LOGGER_ADAPTER;

    private static final ConcurrentMap<String, FailsafeLogger> LOGGERS = new ConcurrentHashMap<String, FailsafeLogger>();

    //查找常用的日志框架
    static {
        String logger = System.getProperty("dubbo.application.logger");
        if ("slf4j".equals(logger)) {
            setLoggerAdapter(new Slf4jLoggerAdaptor());
        }else if("jcl".equals(logger)) {
            setLoggerAdapter(new JclLoggerAdaptor());
        }else if ("log4j".equals(logger)) {
            setLoggerAdapter(new Log4jLoggerAdaptor());
        }else if ("jdk".equals(logger)) {
            setLoggerAdapter(new JdkLoggerAdaptor());
        } else {
            try {
                setLoggerAdapter(new Log4jLoggerAdaptor());
            } catch (Throwable e1) {
                try {
                    setLoggerAdapter(new Slf4jLoggerAdaptor());
                }catch (Throwable e2) {
                    try {
                        setLoggerAdapter(new JclLoggerAdaptor());
                    }catch (Throwable e3) {
                        setLoggerAdapter(new JdkLoggerAdaptor());
                    }
                }
            }
        }
    }

    public static void setLoggerAdapter(String loggerAdapter) {
        if (loggerAdapter != null && loggerAdapter.length() > 0) {
            setLoggerAdapter(ExtensionLoader.getExtensionLoader(LoggerAdapter.class));
        }
    }

    /**
     * 设置日志输出器供给器
     * @param loggerAdapter
     */
    public static void setLoggerAdapter(LoggerAdapter loggerAdapter) {
        if (loggerAdapter != null) {
            Logger logger = loggerAdapter.getLogger(LoggerFactory.class.getName());
            logger.info("using logger: " + loggerAdapter.getClass().getName());
            LoggerFactory.LOGGER_ADAPTER = loggerAdapter;
            for(Map.Entry<String, FailsafeLogger> entry : LOGGERS.entrySet()) {
                entry.getValue().setLogger(LOGGER_ADAPTER.getLogger(entry.getKey()));
            }
        }
    }

    /**
     * 获取日志输出器
     *
     * @param key 分类键
     * @return 日志输出器，后验条件，不返回null
     */
    public static Logger getLogger(Class<?> key) {
        FailsafeLogger logger = LOGGERS.get(key);
        if (logger == null) {
            LOGGERS.putIfAbsent(key.getName(), new FailsafeLogger(LOGGER_ADAPTER.getLogger(key)));
            logger = LOGGERS.get(key.getName());
        }
        return logger;
    }

    /**
     * 获取日志输出器
     *
     * @param key
     *            分类键
     * @return 日志输出器, 后验条件: 不返回null.
     */
    public static Logger getLogger(String key) {
        FailsafeLogger logger = LOGGERS.get(key);
        if (logger == null) {
            LOGGERS.putIfAbsent(key, new FailsafeLogger(LOGGER_ADAPTER.getLogger(key)));
            logger = LOGGERS.get(key);
        }
        return logger;
    }

    /**
     * 设置日志级别
     * @param level
     */
    public static void setLevel(Level level) {
        LOGGER_ADAPTER.setLevel(level);
    }

    /**
     * 获取日志级别
     * @return
     */
    public static Level getLevel() {
        return LOGGER_ADAPTER.getLevel();
    }

    /**
     * 获取日志文件
     * @return
     */
    public static File getFile() {
        return LOGGER_ADAPTER.getFile();
    }

}
