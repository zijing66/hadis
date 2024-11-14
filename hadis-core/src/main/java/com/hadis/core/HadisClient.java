package com.hadis.core;

import com.hadis.core.config.HadisConfig;
import redis.clients.jedis.JedisCluster;

import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/12 17:27
 */
public class HadisClient<T> {

    /**
     * 定时集群状态探测
     */
    private final ScheduledExecutorService scheduledExecutorService;

    private final AtomicReference<String> currentActive = new AtomicReference<>();
    private final ConcurrentHashMap<String, ClientInfo<T>> hadisMap = new ConcurrentHashMap<>();

    public T getClient() {
        return hadisMap.get(currentActive.get()).getRedisHolder().getRedis();
    }

    private void submitStateCheck(String clusterName) {
        if (!hadisMap.containsKey(clusterName)) {
            return;
        }
        this.scheduledExecutorService.scheduleAtFixedRate(() -> {
            ClientInfo<T> clientInfo = hadisMap.get(clusterName);
            System.out.printf("[%s]%s%n", Thread.currentThread().getName(), clientInfo.getHadisConfig());
        }, 10, 10, TimeUnit.SECONDS);
    }

    public HadisClient(SortedMap<String, HadisConfig> haCluster) {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(haCluster.size());
        for (Map.Entry<String, HadisConfig> stringHadisConfigEntry : haCluster.entrySet()) {
            currentActive.set(stringHadisConfigEntry.getKey());
            hadisMap.put(stringHadisConfigEntry.getKey(), new ClientInfo<T>()
                    .setHadisConfig(stringHadisConfigEntry.getValue())
                    .setRedisHolder(new JedisHolder(stringHadisConfigEntry.getValue())));
            submitStateCheck(stringHadisConfigEntry.getKey());
        }
    }

    public static class ClientInfo<T> {
        private HadisConfig hadisConfig;
        private RedisHolder<T> redisHolder;

        public HadisConfig getHadisConfig() {
            return hadisConfig;
        }

        public ClientInfo<T> setHadisConfig(HadisConfig hadisConfig) {
            this.hadisConfig = hadisConfig;
            return this;
        }

        public RedisHolder<T> getRedisHolder() {
            return redisHolder;
        }

        public ClientInfo<T> setRedisHolder(RedisHolder<T> redisHolder) {
            this.redisHolder = redisHolder;
            return this;
        }
    }
}
