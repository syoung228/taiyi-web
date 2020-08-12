package com.taiyi.websiate.taiyiweb.entity;

/**
 * 表名称：case_area
 * 表注释：案例关联地区
 * 
 * @author mybites-generater
 * @createtime 2020-08-12 16:31:55
 * 
 */
public class CaseAreaEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 案例
     */
    private Integer caseId;

    /**
     * 关联地区
     */
    private Integer regionCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }
}