package com.taiyi.websiate.taiyiweb.utils;

import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CompanyInfoEntity;

import java.util.List;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in 2020-08-31
 * @Modity By:
 */
public class ThymeleafViewObject {
    /**
     * 关键词 title等
     */
    public static ThreadLocal<CmsCategoryEntity> header = new ThreadLocal<>();
    /**
     * header 导航
     */
    public static ThreadLocal<List<CmsCategoryEntity>> headerList;
    /**
     * footer信息
     */
    public static ThreadLocal<CompanyInfoEntity> footer;
    /**
     *  详情页 上一条 下一条
     */
    public static ThreadLocal<Object> lastAndNextProgress;
    /**
     * 详情页详情
     */
    public static ThreadLocal<Object> contentResult;
    /**
     * 相关标签
     */
    public static ThreadLocal<Object> tags;
    /**
     * 相关新闻
     */
    public static ThreadLocal<Object> news;
    /**
     * 分类列表
     */
    public static ThreadLocal<Object> categoryList;
    /**
     * 相关案例 id为65
     */
    public static ThreadLocal<Object> relateCase65;
    /**
     *相关案例 id为66
     */
    public static ThreadLocal<Object> relateCase66;
    /**
     * 相关案例 id为67
     */
    public static ThreadLocal<Object> relateCase67;

}
