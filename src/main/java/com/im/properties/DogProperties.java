package com.im.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取properties文件值
 * Created by vostor on 2018/10/25.
 */
@Component
@ConfigurationProperties(prefix = "redis-conf")
public class DogProperties {
    private String REDIS_HOST;
    private Integer REDIS_PORT;
    private Integer REDIS_EXPIRE_TIME;

    public String getRedisHost() {
        return REDIS_HOST;
    }

    public void setRedisHost(String redisHost) {
        REDIS_HOST = redisHost;
    }

    public Integer getRedisPort() {
        return REDIS_PORT;
    }

    public void setRedisPort(Integer redisPort) {
        REDIS_PORT = redisPort;
    }

    public Integer getRedisExpireTime() {
        return REDIS_EXPIRE_TIME;
    }

    public void setRedisExpireTime(Integer redisExpireTime) {
        REDIS_EXPIRE_TIME = redisExpireTime;
    }
}
