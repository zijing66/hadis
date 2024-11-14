package com.hadis.core;

import com.hadis.core.config.HadisConfig;
import redis.clients.jedis.JedisCluster;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/14 10:30
 */
public class JedisHolder<T extends JedisCluster> extends RedisHolder<JedisCluster> {

    public JedisHolder(HadisConfig config) {
        super(config);
    }

    @Override
    public void doInitialize() {
//        setRedis();
    }
}
