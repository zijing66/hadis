package com.hadis.core;

import com.hadis.core.constants.HadisPropKey;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/12 15:05
 */
public class HadisFactory {


    public HadisClient buildClient(Properties clientProperties) {
        String cluster = clientProperties.getProperty(HadisPropKey.CLUSTER_KEY);
        if (StringUtils.isNotBlank(cluster)) {
            String[] clusterNames = cluster.split(",");
            for (String clusterName : clusterNames) {
                String nodes = clientProperties.getProperty(getRedisPropKey(clusterName, HadisPropKey.NODES));
                String passwd = clientProperties.getProperty(getRedisPropKey(clusterName, HadisPropKey.PASSWD));
            }
        }
        return new HadisClient();
    }

    private String getRedisPropKey(String clusterName, String name) {
        return HadisPropKey.HADIS_KEY + clusterName + HadisPropKey.SEPARATOR + name;
    }

}
