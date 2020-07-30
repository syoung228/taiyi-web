package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：project_process_item
 * 表注释：进度项
 * 
 * @author mybites-generater
 * @createtime 2020-07-30 19:56:26
 * 
 */
public class ProjectProcessItemEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

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
}