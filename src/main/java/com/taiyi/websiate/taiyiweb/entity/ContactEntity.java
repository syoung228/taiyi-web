package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：contact
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-08-12 14:46:45
 * 
 */
public class ContactEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String businessQq;

    /**
     * 
     */
    private String businessMobile;

    /**
     * 
     */
    private String businessEmail;

    /**
     * 
     */
    private String saleQq;

    /**
     * 
     */
    private String saleMobile;

    /**
     * 
     */
    private String saleEmail;

    /**
     * 
     */
    private String adress;

    /**
     * 
     */
    private String wechatUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessQq() {
        return businessQq;
    }

    public void setBusinessQq(String businessQq) {
        this.businessQq = businessQq == null ? null : businessQq.trim();
    }

    public String getBusinessMobile() {
        return businessMobile;
    }

    public void setBusinessMobile(String businessMobile) {
        this.businessMobile = businessMobile == null ? null : businessMobile.trim();
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail == null ? null : businessEmail.trim();
    }

    public String getSaleQq() {
        return saleQq;
    }

    public void setSaleQq(String saleQq) {
        this.saleQq = saleQq == null ? null : saleQq.trim();
    }

    public String getSaleMobile() {
        return saleMobile;
    }

    public void setSaleMobile(String saleMobile) {
        this.saleMobile = saleMobile == null ? null : saleMobile.trim();
    }

    public String getSaleEmail() {
        return saleEmail;
    }

    public void setSaleEmail(String saleEmail) {
        this.saleEmail = saleEmail == null ? null : saleEmail.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getWechatUrl() {
        return wechatUrl;
    }

    public void setWechatUrl(String wechatUrl) {
        this.wechatUrl = wechatUrl == null ? null : wechatUrl.trim();
    }
}