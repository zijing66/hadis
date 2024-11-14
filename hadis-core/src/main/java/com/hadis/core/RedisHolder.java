package com.hadis.core;

import com.hadis.core.config.HadisConfig;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/14 10:30
 */
public abstract class RedisHolder<T> {

    private final HadisConfig hadisConfig;
    private T redis;

    public RedisHolder(HadisConfig hadisConfig) {
        this.hadisConfig = hadisConfig;
    }

    public abstract void doInitialize();

    public HadisConfig getHadisConfig() {
        return hadisConfig;
    }

    public T getRedis() {
        return redis;
    }

    public RedisHolder<T> setRedis(T redis) {
        this.redis = redis;
        return this;
    }
}
