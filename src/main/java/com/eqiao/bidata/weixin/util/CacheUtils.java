package com.eqiao.bidata.weixin.util;

import com.eqiao.bidata.weixin.spring.SpringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/**
 * Cache工具类
 * @author iutils.cn
 */
public class CacheUtils {

    private static CacheManager cacheManager = SpringUtils.getBean("shiroCacheManager");

    private static final String SYS_CACHE = PropertyUtil.getProperty("bidata.default.cache");

    /**
     * 获取SYS_CACHE缓存
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return get(SYS_CACHE, key);
    }

    /**
     * 写入SYS_CACHE缓存
     *
     * @param key
     * @return
     */
    public static void put(String key, Object value) {
        put(SYS_CACHE, key, value);
    }

    /**
     * 从SYS_CACHE缓存中移除
     *
     * @param key
     * @return
     */
    public static void remove(String key) {
        remove(SYS_CACHE, key);
    }

    /**
     * 获取缓存
     *
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        return getCache(cacheName).get(key);
    }

    /**
     * 写入缓存
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(key,value);
    }

    /**
     * 从缓存中移除
     *
     * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        getCache(cacheName).clear();
    }

    /**
     * 获得一个Cache
     * @param cacheName
     * @return
     */
    private static Cache getCache(String cacheName) {
        return cacheManager.getCache(cacheName);
    }

}
