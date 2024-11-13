package com.hadis.core.config;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/13 17:51
 */
public class HadisConfig {

    String nodes;
    String passwd;

    public String getNodes() {
        return nodes;
    }

    public HadisConfig setNodes(String nodes) {
        this.nodes = nodes;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public HadisConfig setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }
}
