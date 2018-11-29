package com.im.resp;

/**
 * 返回表格表头实体
 * Created by tss on 2018/11/28.
 */
public class RespTableCol {
    private String label;
    private String prop;
    private String type;
    private String key;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
