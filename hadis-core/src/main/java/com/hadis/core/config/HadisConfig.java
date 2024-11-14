package com.hadis.core.config;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/13 17:51
 */
public class HadisConfig {

    String name;
    String nodes;
    String passwd;

    public String getName() {
        return name;
    }

    public HadisConfig setName(String name) {
        this.name = name;
        return this;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HadisConfig{");
        sb.append("name='").append(name).append('\'');
        sb.append(", nodes='").append(nodes).append('\'');
        sb.append(", passwd='").append(passwd).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
