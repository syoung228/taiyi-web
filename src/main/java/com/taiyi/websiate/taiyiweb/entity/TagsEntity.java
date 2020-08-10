package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：seo_tags
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-08-10 11:33:52
 * 
 */
public class TagsEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 标签名字
     */
    private String tagName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }
}