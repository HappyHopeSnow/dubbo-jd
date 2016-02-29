package com.alibaba.dubbo.config;

import com.sun.org.apache.xalan.internal.Version;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/26 10:21
 */
public abstract class AbstractInterfaceConfig extends AbstractMethodConfig{

    private static final long serialVersionUID = -15324234324324324L;

    protected String local;
    protected String stub;
    protected MonitorConfig monitor;
    protected String proxy;
    protected String cluster;
    protected String filter;
    protected String listener;
    protected String owner;
    protected Integer connetions;
    protected String layer;
    protected ApplicationConfig applicationConfig;
    protected ModuleConfig moduleConfig;
    protected List<Registry> registries;
    protected Integer callbacks;
    protected String onconnect;
    protected String ondisconnect;
    private String scope;

    protected void checkRegistry() {
        //兼容旧版本
        if (registries == null || registries.size() == 0) {
            String address = ConfigUtils.getProperty("dubbo.registry.address");
            if (address != null && address.length() > 0) {
                registries = new ArrayList<Registry>();
                String[] as = address.split("\\s*[|]+\\s*");
                for(String a : as) {
                    RegistryConfig registryConfig = new RegistryConfig();
                    registryConfig.setAddress(a);
                    registries.add(registryConfig);
                }
            }
        }
        if ((registries == null || registries.size() == 0)) {
            throw new IllegalArgumentException((getClass().getSimpleName().startsWith("Reference")
            ?"No such any registry to refer service in consumer"
            : "No such any registry to export service in provider")
            + NetUtils.getLocalHost()
            + " use dubbo version "
            + Version.getVersion()
            + ", please add <dubbo:registry address \"...\" /> to your spring config. ");
        }
        for(RegistryConfig registryConfig : registries) {
            appendProperties(registryConfig);
        }
    }

    @SuppressWarnings("deprecation")
    protected void checkApplication() {
        //兼容旧版本
        if (application == null) {
            String applicationName = ConfigUtils.getProperty("dubbo.application.name");
            if (applicationName != null && applicationName.length() > 0) {
                application = new ApplicationConfig();
            }
        }
        if (application == null) {
            throw new IllegalStateException("No such application config ! please add <dubbo:application name")
        }
        appendProperties(application);

        String wait = ConfigUtils.getProperty(Constans.SHUTDOWN_WAIT_KEY);
        if (wait != null && wait.trim().length() > 0) {
            System.setProperty(Constants.SHUTDOWN_WAIT_KEY, wait.trim());
        }else {
            wait = ConfigUtils.getProperty(Constans.SHUTDOWN_WAIT_SECONDS_KEY);
            if (wait != null && wait.trim().length() > 0) {
                System.setProperty(Constants.SHUTDOWN_WAIT_SECONDS_KEY, wait.trim());
            }
        }
    }

    protected List<URL> loadRegistries(boolean provider) {
        checkRegistry();
        List<URL> registryList = new ArrayList<URL>();
        if (registries != null && registries.size() > 0) {
            for(RegistryConfig config : registries) {

            }
        }
    }

}
