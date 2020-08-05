package com.taiyi.websiate.taiyiweb.dto;

import com.taiyi.websiate.taiyiweb.entity.CmsContentEntity;

import java.util.Date;
import java.util.List;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
public class CmsCategoryDto {
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
     * 栏目管理关键字
     */
    private String categoryKeyword;


    /**
     * 父类型编号
     */
    private String categoryParentId;


    /**
     * 自定义链接
     */
    private String categoryDiyUrl;

    /**
     * 自定义顺序
     */
    private Integer categorySort;


    /**
     * 所属栏目
     */
    private String categoryId;

    private List<CmsContentEntity> cmsContentEntities;

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
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getCategoryKeyword() {
        return categoryKeyword;
    }

    public void setCategoryKeyword(String categoryKeyword) {
        this.categoryKeyword = categoryKeyword;
    }

    public String getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(String categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    public String getCategoryDiyUrl() {
        return categoryDiyUrl;
    }

    public void setCategoryDiyUrl(String categoryDiyUrl) {
        this.categoryDiyUrl = categoryDiyUrl;
    }

    public Integer getCategorySort() {
        return categorySort;
    }

    public void setCategorySort(Integer categorySort) {
        this.categorySort = categorySort;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<CmsContentEntity> getCmsContentEntities() {
        return cmsContentEntities;
    }

    public void setCmsContentEntities(List<CmsContentEntity> cmsContentEntities) {
        this.cmsContentEntities = cmsContentEntities;
    }
}
