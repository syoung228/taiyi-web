package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：case_province
 * 表注释：
 * 
 * @author mybites-generater
 * @createtime 2020-08-03 10:36:33
 * 
 */
public class caseProvinceEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer cmsContemtId;

    /**
     * 关联市
     */
    private String cityCode;

    /**
     * 关联省
     */
    private String provinceCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCmsContemtId() {
        return cmsContemtId;
    }

    public void setCmsContemtId(Integer cmsContemtId) {
        this.cmsContemtId = cmsContemtId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }
}