package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：region
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-08-03 10:35:29
 * 
 */
public class RegionEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}