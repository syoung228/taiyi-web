package com.taiyi.websiate.taiyiweb.utils;

import com.taiyi.websiate.taiyiweb.entity.CmsCategoryEntity;
import com.taiyi.websiate.taiyiweb.entity.CompanyInfoEntity;

import java.util.ArrayList;
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
    public static CmsCategoryEntity header = new CmsCategoryEntity();
    /**
     * header 导航
     */
    public static List<CmsCategoryEntity> headerList =new ArrayList<>();
    /**
     * footer信息
     */
    public static CompanyInfoEntity footer = new CompanyInfoEntity();
    /**
     *  详情页 上一条 下一条
     */
    public static Object lastAndNextProgress  = new Object();
    /**
     * 详情页详情
     */
    public static Object contentResult = new Object();
    /**
     * 文章列表
     */
    public static Object contentList = new Object();
    /**
     * 相关标签
     */
    public static Object tags = new Object();
    /**
     * 相关新闻
     */
    public static Object news = new Object();
    /**
     * 分类列表
     */
    public static Object categoryList = new Object();
    /**
     * 相关案例 id为65
     */
    public static Object relateCase65 = new Object();
    /**
     *相关案例 id为66
     */
    public static Object relateCase66 = new Object();
    /**
     * 相关案例 id为67
     */
    public static Object relateCase67 = new Object();

}
