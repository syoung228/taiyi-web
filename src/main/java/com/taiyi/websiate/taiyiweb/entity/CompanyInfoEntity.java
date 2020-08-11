package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：company_info
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-08-11 10:42:58
 * 
 */
public class CompanyInfoEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAdress;

    /**
     * 服务热线
     */
    private String serverMobile;

    /**
     * 售后
     */
    private String saleMobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 公司微信
     */
    private String companyWechatUrl;

    /**
     * 销售微信
     */
    private String saleWechatUrl;

    /**
     * 友情链接
     */
    private String links;

    /**
     * 备案信息
     */
    private String recordInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress == null ? null : companyAdress.trim();
    }

    public String getServerMobile() {
        return serverMobile;
    }

    public void setServerMobile(String serverMobile) {
        this.serverMobile = serverMobile == null ? null : serverMobile.trim();
    }

    public String getSaleMobile() {
        return saleMobile;
    }

    public void setSaleMobile(String saleMobile) {
        this.saleMobile = saleMobile == null ? null : saleMobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompanyWechatUrl() {
        return companyWechatUrl;
    }

    public void setCompanyWechatUrl(String companyWechatUrl) {
        this.companyWechatUrl = companyWechatUrl == null ? null : companyWechatUrl.trim();
    }

    public String getSaleWechatUrl() {
        return saleWechatUrl;
    }

    public void setSaleWechatUrl(String saleWechatUrl) {
        this.saleWechatUrl = saleWechatUrl == null ? null : saleWechatUrl.trim();
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links == null ? null : links.trim();
    }

    public String getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(String recordInfo) {
        this.recordInfo = recordInfo == null ? null : recordInfo.trim();
    }
}