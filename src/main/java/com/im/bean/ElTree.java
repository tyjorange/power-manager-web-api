package com.im.bean;

import java.util.List;

/**
 * 树形控件实体类
 * Created by tss on 2019/1/23.
 */
public class ElTree {
    private String id;
    private String label;
    private List<ElTree> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ElTree> getChildren() {
        return children;
    }

    public void setChildren(List<ElTree> children) {
        this.children = children;
    }
}
