package com.taiyi.websiate.taiyiweb.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Date;

/**
 * 表名称：cms_category
 * 表注释：分类
 *
 * @author mybites-generater
 * @createtime 2020-07-30 19:56:26
 *
 */
public class CmsCategoryEntity {
    /**
     *
     */
    private Integer id;

    /**
     * 栏目管理名称
     */
    private String categoryTitle;

    /**
     * 缩略图
     */
    private String categoryImg;

    /**
     * 栏目属性
     */
    private String categoryFlag;

    /**
     * 栏目管理描述
     */
    private String categoryDescrip;

    /**
     * 栏目管理关键字
     */
    private String categoryKeyword;

    /**
     * 栏目路径
     */
    private String categoryPath;

    /**
     * 父类型编号
     */
    private String categoryParentId;

    /**
     * 字典对应编号
     */
    private Integer dictId;

    /**
     * 应用编号
     */
    private Integer appId;

    /**
     * 发布用户id
     */
    private Integer categoryManagerId;

    /**
     * 类别发布时间
     */
    private Date categoryDatetime;

    /**
     * 栏目管理的内容模型id
     */
    private String mdiyModelId;

    /**
     * 自定义链接
     */
    private String categoryDiyUrl;

    /**
     * 内容模板
     */
    private String categoryUrl;

    /**
     * 列表模板
     */
    private String categoryListUrl;

    /**
     * 自定义顺序
     */
    private Integer categorySort;

    /**
     * 栏目管理属性
     */
    private String categoryType;

    /**
     * 所属栏目
     */
    private String categoryId;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle == null ? null : categoryTitle.trim();
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        JSONArray json = JSONArray.parseArray(categoryImg);
        if(json!=null&&json.size()>0){
            this.categoryImg  ="http://8.210.152.23"+ (String) json.getJSONObject(0).get("path");
        }else{
            this.categoryImg = null;
        }
    }

    public String getCategoryFlag() {
        return categoryFlag;
    }

    public void setCategoryFlag(String categoryFlag) {
        this.categoryFlag = categoryFlag == null ? null : categoryFlag.trim();
    }

    public String getCategoryDescrip() {
        return categoryDescrip;
    }

    public void setCategoryDescrip(String categoryDescrip) {
        this.categoryDescrip = categoryDescrip == null ? null : categoryDescrip.trim();
    }

    public String getCategoryKeyword() {
        return categoryKeyword;
    }

    public void setCategoryKeyword(String categoryKeyword) {
        this.categoryKeyword = categoryKeyword == null ? null : categoryKeyword.trim();
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath == null ? null : categoryPath.trim();
    }

    public String getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(String categoryParentId) {
        this.categoryParentId = categoryParentId == null ? null : categoryParentId.trim();
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getCategoryManagerId() {
        return categoryManagerId;
    }

    public void setCategoryManagerId(Integer categoryManagerId) {
        this.categoryManagerId = categoryManagerId;
    }

    public Date getCategoryDatetime() {
        return categoryDatetime;
    }

    public void setCategoryDatetime(Date categoryDatetime) {
        this.categoryDatetime = categoryDatetime;
    }

    public String getMdiyModelId() {
        return mdiyModelId;
    }

    public void setMdiyModelId(String mdiyModelId) {
        this.mdiyModelId = mdiyModelId == null ? null : mdiyModelId.trim();
    }

    public String getCategoryDiyUrl() {
        return categoryDiyUrl;
    }

    public void setCategoryDiyUrl(String categoryDiyUrl) {
        this.categoryDiyUrl = categoryDiyUrl == null ? null : categoryDiyUrl.trim();
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl == null ? null : categoryUrl.trim();
    }

    public String getCategoryListUrl() {
        return categoryListUrl;
    }

    public void setCategoryListUrl(String categoryListUrl) {
        this.categoryListUrl = categoryListUrl == null ? null : categoryListUrl.trim();
    }

    public Integer getCategorySort() {
        return categorySort;
    }

    public void setCategorySort(Integer categorySort) {
        this.categorySort = categorySort;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType == null ? null : categoryType.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
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
}
