package com.taiyi.websiate.taiyiweb.dto;

import com.alibaba.fastjson.JSONArray;
import com.taiyi.websiate.taiyiweb.entity.ProjectProcessInfoEntity;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
public class ProjectDto {
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

    /**
     * 项目时间
     */
    private Long createTime;
    /**
     * 年
     */
    private String year;
    /**
     * 月日
     */
    private String monthDay;
    /**
     * 进度详情
     */
    private List<ProjectProcessInfoDto> projectProcessInfo;

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
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        this.des = des;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        JSONArray json = JSONArray.parseArray(imgUrl);
        if(json!=null&&json.size()>0){
            this.imgUrl  ="http://8.210.152.23"+ (String) json.getJSONObject(0).get("path");
        }else{
            this.imgUrl = null;
        }
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy");
        this.year=format.format(createTime);
        SimpleDateFormat format2 =  new SimpleDateFormat("MM-dd");
        this.monthDay = format2.format(createTime);
        this.createTime = createTime;
    }

    public List<ProjectProcessInfoDto> getProjectProcessInfo() {
        return projectProcessInfo;
    }

    public void setProjectProcessInfo(List<ProjectProcessInfoDto> projectProcessInfo) {
        this.projectProcessInfo = projectProcessInfo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(String monthDay) {
        this.monthDay = monthDay;
    }
}
