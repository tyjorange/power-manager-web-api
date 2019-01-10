package com.im.bean;

import java.util.List;

/**
 * 下拉菜单实体
 * Created by vostor on 2019/1/9.
 */
public class ElCascader {
    private String value;
    private String label;
    private List<ElCascader> children;

    public List<ElCascader> getChildren() {
        return children;
    }

    public void setChildren(List<ElCascader> children) {
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
