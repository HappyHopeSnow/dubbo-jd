package com.jd.dubbo.common.logger;

import com.jd.dubbo.common.extension.SPI;

import java.io.File;

/**
 * Description: <br>
 * 日志输出器供给器
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/21 19:58
 */
@SPI
public interface LoggerAdapter {

    Logger getLogger(Class<?> key);

    Logger getLogger(String key);

    void setLevel(Level level);

    Level getLevel();

    File getFile();

    void setFile(File file);
}
