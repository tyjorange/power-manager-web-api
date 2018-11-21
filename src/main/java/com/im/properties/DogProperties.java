package com.im.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取properties文件值
 * Created by vostor on 2018/10/25.
 */
@Component
@ConfigurationProperties(prefix = "dog")
public class DogProperties {
    private String v1;
    private Integer v2;

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public Integer getV2() {
        return v2;
    }

    public void setV2(Integer v2) {
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "DogProperties{" +
                "v1='" + v1 + '\'' +
                ", v2=" + v2 +
                '}';
    }
}
