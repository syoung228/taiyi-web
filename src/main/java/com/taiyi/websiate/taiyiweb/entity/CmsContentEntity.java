package com.taiyi.websiate.taiyiweb.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Date;

/**
 * 表名称：cms_content
 * 表注释：文章
 *
 * @author mybites-generater
 * @createtime 2020-07-30 19:56:26
 *
 */
public class CmsContentEntity {
    /**
     *
     */
    private Integer id;

    /**
     * 文章管理的应用id
     */
    private Integer appId;

    /**
     * 文章标题
     */
    private String contentTitle;

    /**
     * 所属栏目
     */
    private String contentCategoryId;

    /**
     * 文章跳转链接地址
     */
    private String contentUrl;

    /**
     * 关键字
     */
    private String contentKeyword;

    /**
     * 描述
     */
    private String contentDescription;

    /**
     * 文章缩略图
     */
    private String contentImg;

    /**
     * 自定义顺序
     */
    private Integer contentSort;

    /**
     * 发布时间
     */
    private Date contentDatetime;

    /**
     * 文章来源
     */
    private String contentSource;

    /**
     * 文章作者
     */
    private String contentAuthor;

    /**
     * 是否显示
     */
    private String contentDisplay;

    /**
     * 文章类型
     */
    private String contentType;

    /**
     * 点击次数
     */
    private Long contentHit;

    /**
     * 删除标记
     */
    private Integer del;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 文章内容
     */
    private String contentDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle == null ? null : contentTitle.trim();
    }

    public String getContentCategoryId() {
        return contentCategoryId;
    }

    public void setContentCategoryId(String contentCategoryId) {
        this.contentCategoryId = contentCategoryId == null ? null : contentCategoryId.trim();
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl == null ? null : contentUrl.trim();
    }

    public String getContentKeyword() {
        return contentKeyword;
    }

    public void setContentKeyword(String contentKeyword) {
        this.contentKeyword = contentKeyword == null ? null : contentKeyword.trim();
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription == null ? null : contentDescription.trim();
    }

    public String getContentImg() {
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        JSONArray json = JSONArray.parseArray(contentImg);
        if(json!=null&&json.size()>0){
            this.contentImg  = (String) json.getJSONObject(0).get("path");
        }else{
            this.contentImg = null;
        }
    }

    public Integer getContentSort() {
        return contentSort;
    }

    public void setContentSort(Integer contentSort) {
        this.contentSort = contentSort;
    }

    public Date getContentDatetime() {
        return contentDatetime;
    }

    public void setContentDatetime(Date contentDatetime) {
        this.contentDatetime = contentDatetime;
    }

    public String getContentSource() {
        return contentSource;
    }

    public void setContentSource(String contentSource) {
        this.contentSource = contentSource == null ? null : contentSource.trim();
    }

    public String getContentAuthor() {
        return contentAuthor;
    }

    public void setContentAuthor(String contentAuthor) {
        this.contentAuthor = contentAuthor == null ? null : contentAuthor.trim();
    }

    public String getContentDisplay() {
        return contentDisplay;
    }

    public void setContentDisplay(String contentDisplay) {
        this.contentDisplay = contentDisplay == null ? null : contentDisplay.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public Long getContentHit() {
        return contentHit;
    }

    public void setContentHit(Long contentHit) {
        this.contentHit = contentHit;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(String contentDetails) {
        this.contentDetails = contentDetails == null ? null : contentDetails.trim();
    }
}
