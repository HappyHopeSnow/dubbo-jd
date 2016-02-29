package com.alibaba.dubbo.config.utils;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/16 14:57
 */
public class ReferenceConfigCache {

    public static final String DEFAULT_NAME = "_DEFAULT_";
    static final ConcurrentMap<String, ReferenceConfigCache> cacheHolder = new ConcurrentHashMap<String, ReferenceConfigCache>();

    public static ReferenceConfigCache getCache() {return getCache(DEFAULT_NAME);}

    public static ReferenceConfigCache getCache(String name) {
        return getCache(name, DEFAULT_KEY_GENERATOR);
    }

    public static ReferenceConfigCache getCache(String name, KeyGenerator keyGenerator) {
        ReferenceConfigCache cache = cacheHolder.get(name);
        if (cache != null) {
            return cache;
        }
        cacheHolder.putIfAbsent(name, new ReferenceConfigCache(name, keyGenerator));
        return cacheHolder.get(name);
    }


    public static interface KeyGenerator {
        String generateKey(ReferenceConfige<?> referenceConfige);
    }

    public static final KeyGenerator DEFAULT_KEY_GENERATOR = new KeyGenerator() {
        public String generateKey(ReferenceConfige<?> referenceConfige) {
            String iName = referenceConfige.getInterface();
            if (StringUtils.isBlank(iName)) {
                Class<?> clazz = referenceConfige.getInterfaceClass();
                iName = clazz.getName();
            }
            if (StringUtils.isBlank(iName)) {
                throw new IllegalArgumentException("No interface info in ReferenceConfige " + referenceConfige);
            }

            StringBuilder ret = new StringBuilder();
            if (!StringUtils.isBlank(referenceConfige.getGroup())) {
                ret.append(referenceConfige.getGroup()).append("/");
            }
            ret.append(iName);
            if (!StringUtils.isBlank(referenceConfige.getVersion())) {
                ret.append(":").append(referenceConfige.getVersion());
            }

            return ret.toString();
        }
    };

    private final String name;
    private final KeyGenerator generator;

    ConcurrentMap<String, ReferenceConfig<?>> cache = new ConcurrentHashMap<String, ReferenceConfig<?>>();

    private ReferenceConfigCache(String name, KeyGenerator generator) {
        this.name = name;
        this.generator = generator;
    }

    public <T> T get(ReferenceConfig<T> referenceConfig) {
        String key = generator.generateKey(referenceConfig);

        ReferenceConfig<?> config = cache.get(key);
        if (config != null) {
            return (T)config.get();
        }

        cache.put(key, referenceConfig);
        config = cache.get(key);
        return (T) config.get(key);
    }

    void destoryKey(String key) {
        ReferenceConfig<?> config = cache.remove(key);
        if (config == null) return;
        config.destory();
    }

    public <T> void destory(ReferenceConfig<T> referenceConfig) {
        String key = generator.generateKey(referenceConfig);
        destoryKey(key);
    }

    public void destoryAll() {
        Set<String> set = new HashSet<String>(cache.size());
        for(String key : set) {
            destoryKey(key);
        }
    }

    @Override
    public String toString() {
        return "ReferenceConfigCache(name: " + name + ")";
    }


}
