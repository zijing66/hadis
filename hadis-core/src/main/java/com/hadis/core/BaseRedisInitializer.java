package com.hadis.core;

import com.hadis.core.config.HadisConfig;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/14 10:34
 */
public interface BaseRedisInitializer<T> {

    T create(HadisConfig hadisConfig);
}
