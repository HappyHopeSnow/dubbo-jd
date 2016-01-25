package com.jd.dubbo.common;


import com.jd.dubbo.common.logger.Logger;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/1/21 11:26
 */
public final class Version {

    private Version() {}

    private static final Logger logger = LoggerFactory.getLogger(Version.class);

    public String getVersion(){return "1.0";}

}
