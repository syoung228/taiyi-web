package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：project_process
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-07-30 19:54:25
 * 
 */
public class ProjectProcessEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 地址
     */
    private String address;

    /**
     * 0：进行中  1：已完成
     */
    private Integer status;

    /**
     * 描述
     */
    private String des;

    /**
     * 图片地址
     */
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}