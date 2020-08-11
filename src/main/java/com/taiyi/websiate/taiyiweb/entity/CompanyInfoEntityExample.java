package com.taiyi.websiate.taiyiweb.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfoEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart;

    protected int limitEnd;

    protected String groupByClause;

    public CompanyInfoEntityExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause=groupByClause;
    }

    public String getGroupByClause() {
        return groupByClause;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressIsNull() {
            addCriterion("company_adress is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressIsNotNull() {
            addCriterion("company_adress is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressEqualTo(String value) {
            addCriterion("company_adress =", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressNotEqualTo(String value) {
            addCriterion("company_adress <>", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressGreaterThan(String value) {
            addCriterion("company_adress >", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressGreaterThanOrEqualTo(String value) {
            addCriterion("company_adress >=", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressLessThan(String value) {
            addCriterion("company_adress <", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressLessThanOrEqualTo(String value) {
            addCriterion("company_adress <=", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressLike(String value) {
            addCriterion("company_adress like", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressNotLike(String value) {
            addCriterion("company_adress not like", value, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressIn(List<String> values) {
            addCriterion("company_adress in", values, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressNotIn(List<String> values) {
            addCriterion("company_adress not in", values, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressBetween(String value1, String value2) {
            addCriterion("company_adress between", value1, value2, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andCompanyAdressNotBetween(String value1, String value2) {
            addCriterion("company_adress not between", value1, value2, "companyAdress");
            return (Criteria) this;
        }

        public Criteria andServerMobileIsNull() {
            addCriterion("server_mobile is null");
            return (Criteria) this;
        }

        public Criteria andServerMobileIsNotNull() {
            addCriterion("server_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andServerMobileEqualTo(String value) {
            addCriterion("server_mobile =", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileNotEqualTo(String value) {
            addCriterion("server_mobile <>", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileGreaterThan(String value) {
            addCriterion("server_mobile >", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileGreaterThanOrEqualTo(String value) {
            addCriterion("server_mobile >=", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileLessThan(String value) {
            addCriterion("server_mobile <", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileLessThanOrEqualTo(String value) {
            addCriterion("server_mobile <=", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileLike(String value) {
            addCriterion("server_mobile like", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileNotLike(String value) {
            addCriterion("server_mobile not like", value, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileIn(List<String> values) {
            addCriterion("server_mobile in", values, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileNotIn(List<String> values) {
            addCriterion("server_mobile not in", values, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileBetween(String value1, String value2) {
            addCriterion("server_mobile between", value1, value2, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andServerMobileNotBetween(String value1, String value2) {
            addCriterion("server_mobile not between", value1, value2, "serverMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileIsNull() {
            addCriterion("sale_mobile is null");
            return (Criteria) this;
        }

        public Criteria andSaleMobileIsNotNull() {
            addCriterion("sale_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andSaleMobileEqualTo(String value) {
            addCriterion("sale_mobile =", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileNotEqualTo(String value) {
            addCriterion("sale_mobile <>", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileGreaterThan(String value) {
            addCriterion("sale_mobile >", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileGreaterThanOrEqualTo(String value) {
            addCriterion("sale_mobile >=", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileLessThan(String value) {
            addCriterion("sale_mobile <", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileLessThanOrEqualTo(String value) {
            addCriterion("sale_mobile <=", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileLike(String value) {
            addCriterion("sale_mobile like", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileNotLike(String value) {
            addCriterion("sale_mobile not like", value, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileIn(List<String> values) {
            addCriterion("sale_mobile in", values, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileNotIn(List<String> values) {
            addCriterion("sale_mobile not in", values, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileBetween(String value1, String value2) {
            addCriterion("sale_mobile between", value1, value2, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andSaleMobileNotBetween(String value1, String value2) {
            addCriterion("sale_mobile not between", value1, value2, "saleMobile");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlIsNull() {
            addCriterion("company_wechat_url is null");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlIsNotNull() {
            addCriterion("company_wechat_url is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlEqualTo(String value) {
            addCriterion("company_wechat_url =", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlNotEqualTo(String value) {
            addCriterion("company_wechat_url <>", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlGreaterThan(String value) {
            addCriterion("company_wechat_url >", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlGreaterThanOrEqualTo(String value) {
            addCriterion("company_wechat_url >=", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlLessThan(String value) {
            addCriterion("company_wechat_url <", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlLessThanOrEqualTo(String value) {
            addCriterion("company_wechat_url <=", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlLike(String value) {
            addCriterion("company_wechat_url like", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlNotLike(String value) {
            addCriterion("company_wechat_url not like", value, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlIn(List<String> values) {
            addCriterion("company_wechat_url in", values, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlNotIn(List<String> values) {
            addCriterion("company_wechat_url not in", values, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlBetween(String value1, String value2) {
            addCriterion("company_wechat_url between", value1, value2, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyWechatUrlNotBetween(String value1, String value2) {
            addCriterion("company_wechat_url not between", value1, value2, "companyWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlIsNull() {
            addCriterion("sale_wechat_url is null");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlIsNotNull() {
            addCriterion("sale_wechat_url is not null");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlEqualTo(String value) {
            addCriterion("sale_wechat_url =", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlNotEqualTo(String value) {
            addCriterion("sale_wechat_url <>", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlGreaterThan(String value) {
            addCriterion("sale_wechat_url >", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sale_wechat_url >=", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlLessThan(String value) {
            addCriterion("sale_wechat_url <", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlLessThanOrEqualTo(String value) {
            addCriterion("sale_wechat_url <=", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlLike(String value) {
            addCriterion("sale_wechat_url like", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlNotLike(String value) {
            addCriterion("sale_wechat_url not like", value, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlIn(List<String> values) {
            addCriterion("sale_wechat_url in", values, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlNotIn(List<String> values) {
            addCriterion("sale_wechat_url not in", values, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlBetween(String value1, String value2) {
            addCriterion("sale_wechat_url between", value1, value2, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andSaleWechatUrlNotBetween(String value1, String value2) {
            addCriterion("sale_wechat_url not between", value1, value2, "saleWechatUrl");
            return (Criteria) this;
        }

        public Criteria andLinksIsNull() {
            addCriterion("links is null");
            return (Criteria) this;
        }

        public Criteria andLinksIsNotNull() {
            addCriterion("links is not null");
            return (Criteria) this;
        }

        public Criteria andLinksEqualTo(String value) {
            addCriterion("links =", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksNotEqualTo(String value) {
            addCriterion("links <>", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksGreaterThan(String value) {
            addCriterion("links >", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksGreaterThanOrEqualTo(String value) {
            addCriterion("links >=", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksLessThan(String value) {
            addCriterion("links <", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksLessThanOrEqualTo(String value) {
            addCriterion("links <=", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksLike(String value) {
            addCriterion("links like", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksNotLike(String value) {
            addCriterion("links not like", value, "links");
            return (Criteria) this;
        }

        public Criteria andLinksIn(List<String> values) {
            addCriterion("links in", values, "links");
            return (Criteria) this;
        }

        public Criteria andLinksNotIn(List<String> values) {
            addCriterion("links not in", values, "links");
            return (Criteria) this;
        }

        public Criteria andLinksBetween(String value1, String value2) {
            addCriterion("links between", value1, value2, "links");
            return (Criteria) this;
        }

        public Criteria andLinksNotBetween(String value1, String value2) {
            addCriterion("links not between", value1, value2, "links");
            return (Criteria) this;
        }

        public Criteria andRecordInfoIsNull() {
            addCriterion("record_info is null");
            return (Criteria) this;
        }

        public Criteria andRecordInfoIsNotNull() {
            addCriterion("record_info is not null");
            return (Criteria) this;
        }

        public Criteria andRecordInfoEqualTo(String value) {
            addCriterion("record_info =", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoNotEqualTo(String value) {
            addCriterion("record_info <>", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoGreaterThan(String value) {
            addCriterion("record_info >", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoGreaterThanOrEqualTo(String value) {
            addCriterion("record_info >=", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoLessThan(String value) {
            addCriterion("record_info <", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoLessThanOrEqualTo(String value) {
            addCriterion("record_info <=", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoLike(String value) {
            addCriterion("record_info like", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoNotLike(String value) {
            addCriterion("record_info not like", value, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoIn(List<String> values) {
            addCriterion("record_info in", values, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoNotIn(List<String> values) {
            addCriterion("record_info not in", values, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoBetween(String value1, String value2) {
            addCriterion("record_info between", value1, value2, "recordInfo");
            return (Criteria) this;
        }

        public Criteria andRecordInfoNotBetween(String value1, String value2) {
            addCriterion("record_info not between", value1, value2, "recordInfo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}