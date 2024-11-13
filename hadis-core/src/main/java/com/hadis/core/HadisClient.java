package com.hadis.core;

import com.hadis.core.config.HadisConfig;

import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/12 17:27
 */
public class HadisClient {

    /**
     * 定时集群状态探测
     */
    private ScheduledExecutorService scheduledExecutorService;

    private Map<String, HadisConfig> haCluster;

    public HadisClient() {
        this.scheduledExecutorService = null;
    }
}
