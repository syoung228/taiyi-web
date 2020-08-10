package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：content_tags
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-08-10 11:33:52
 * 
 */
public class ContentTagsEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer contenId;

    /**
     * 
     */
    private Integer tagId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContenId() {
        return contenId;
    }

    public void setContenId(Integer contenId) {
        this.contenId = contenId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}