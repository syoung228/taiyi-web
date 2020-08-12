package com.taiyi.websiate.taiyiweb.entity;

import java.util.ArrayList;
import java.util.List;

public class ContactEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart;

    protected int limitEnd;

    protected String groupByClause;

    public ContactEntityExample() {
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

        public Criteria andBusinessQqIsNull() {
            addCriterion("business_qq is null");
            return (Criteria) this;
        }

        public Criteria andBusinessQqIsNotNull() {
            addCriterion("business_qq is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessQqEqualTo(String value) {
            addCriterion("business_qq =", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqNotEqualTo(String value) {
            addCriterion("business_qq <>", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqGreaterThan(String value) {
            addCriterion("business_qq >", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqGreaterThanOrEqualTo(String value) {
            addCriterion("business_qq >=", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqLessThan(String value) {
            addCriterion("business_qq <", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqLessThanOrEqualTo(String value) {
            addCriterion("business_qq <=", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqLike(String value) {
            addCriterion("business_qq like", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqNotLike(String value) {
            addCriterion("business_qq not like", value, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqIn(List<String> values) {
            addCriterion("business_qq in", values, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqNotIn(List<String> values) {
            addCriterion("business_qq not in", values, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqBetween(String value1, String value2) {
            addCriterion("business_qq between", value1, value2, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessQqNotBetween(String value1, String value2) {
            addCriterion("business_qq not between", value1, value2, "businessQq");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileIsNull() {
            addCriterion("business_mobile is null");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileIsNotNull() {
            addCriterion("business_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileEqualTo(String value) {
            addCriterion("business_mobile =", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotEqualTo(String value) {
            addCriterion("business_mobile <>", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileGreaterThan(String value) {
            addCriterion("business_mobile >", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileGreaterThanOrEqualTo(String value) {
            addCriterion("business_mobile >=", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileLessThan(String value) {
            addCriterion("business_mobile <", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileLessThanOrEqualTo(String value) {
            addCriterion("business_mobile <=", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileLike(String value) {
            addCriterion("business_mobile like", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotLike(String value) {
            addCriterion("business_mobile not like", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileIn(List<String> values) {
            addCriterion("business_mobile in", values, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotIn(List<String> values) {
            addCriterion("business_mobile not in", values, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileBetween(String value1, String value2) {
            addCriterion("business_mobile between", value1, value2, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotBetween(String value1, String value2) {
            addCriterion("business_mobile not between", value1, value2, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailIsNull() {
            addCriterion("business_email is null");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailIsNotNull() {
            addCriterion("business_email is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailEqualTo(String value) {
            addCriterion("business_email =", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailNotEqualTo(String value) {
            addCriterion("business_email <>", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailGreaterThan(String value) {
            addCriterion("business_email >", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailGreaterThanOrEqualTo(String value) {
            addCriterion("business_email >=", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailLessThan(String value) {
            addCriterion("business_email <", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailLessThanOrEqualTo(String value) {
            addCriterion("business_email <=", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailLike(String value) {
            addCriterion("business_email like", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailNotLike(String value) {
            addCriterion("business_email not like", value, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailIn(List<String> values) {
            addCriterion("business_email in", values, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailNotIn(List<String> values) {
            addCriterion("business_email not in", values, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailBetween(String value1, String value2) {
            addCriterion("business_email between", value1, value2, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessEmailNotBetween(String value1, String value2) {
            addCriterion("business_email not between", value1, value2, "businessEmail");
            return (Criteria) this;
        }

        public Criteria andSaleQqIsNull() {
            addCriterion("sale_qq is null");
            return (Criteria) this;
        }

        public Criteria andSaleQqIsNotNull() {
            addCriterion("sale_qq is not null");
            return (Criteria) this;
        }

        public Criteria andSaleQqEqualTo(String value) {
            addCriterion("sale_qq =", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqNotEqualTo(String value) {
            addCriterion("sale_qq <>", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqGreaterThan(String value) {
            addCriterion("sale_qq >", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqGreaterThanOrEqualTo(String value) {
            addCriterion("sale_qq >=", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqLessThan(String value) {
            addCriterion("sale_qq <", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqLessThanOrEqualTo(String value) {
            addCriterion("sale_qq <=", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqLike(String value) {
            addCriterion("sale_qq like", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqNotLike(String value) {
            addCriterion("sale_qq not like", value, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqIn(List<String> values) {
            addCriterion("sale_qq in", values, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqNotIn(List<String> values) {
            addCriterion("sale_qq not in", values, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqBetween(String value1, String value2) {
            addCriterion("sale_qq between", value1, value2, "saleQq");
            return (Criteria) this;
        }

        public Criteria andSaleQqNotBetween(String value1, String value2) {
            addCriterion("sale_qq not between", value1, value2, "saleQq");
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

        public Criteria andSaleEmailIsNull() {
            addCriterion("sale_email is null");
            return (Criteria) this;
        }

        public Criteria andSaleEmailIsNotNull() {
            addCriterion("sale_email is not null");
            return (Criteria) this;
        }

        public Criteria andSaleEmailEqualTo(String value) {
            addCriterion("sale_email =", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailNotEqualTo(String value) {
            addCriterion("sale_email <>", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailGreaterThan(String value) {
            addCriterion("sale_email >", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailGreaterThanOrEqualTo(String value) {
            addCriterion("sale_email >=", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailLessThan(String value) {
            addCriterion("sale_email <", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailLessThanOrEqualTo(String value) {
            addCriterion("sale_email <=", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailLike(String value) {
            addCriterion("sale_email like", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailNotLike(String value) {
            addCriterion("sale_email not like", value, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailIn(List<String> values) {
            addCriterion("sale_email in", values, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailNotIn(List<String> values) {
            addCriterion("sale_email not in", values, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailBetween(String value1, String value2) {
            addCriterion("sale_email between", value1, value2, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andSaleEmailNotBetween(String value1, String value2) {
            addCriterion("sale_email not between", value1, value2, "saleEmail");
            return (Criteria) this;
        }

        public Criteria andAdressIsNull() {
            addCriterion("adress is null");
            return (Criteria) this;
        }

        public Criteria andAdressIsNotNull() {
            addCriterion("adress is not null");
            return (Criteria) this;
        }

        public Criteria andAdressEqualTo(String value) {
            addCriterion("adress =", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotEqualTo(String value) {
            addCriterion("adress <>", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThan(String value) {
            addCriterion("adress >", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThanOrEqualTo(String value) {
            addCriterion("adress >=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThan(String value) {
            addCriterion("adress <", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThanOrEqualTo(String value) {
            addCriterion("adress <=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLike(String value) {
            addCriterion("adress like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotLike(String value) {
            addCriterion("adress not like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressIn(List<String> values) {
            addCriterion("adress in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotIn(List<String> values) {
            addCriterion("adress not in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressBetween(String value1, String value2) {
            addCriterion("adress between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotBetween(String value1, String value2) {
            addCriterion("adress not between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andWechatUrlIsNull() {
            addCriterion("wechat_url is null");
            return (Criteria) this;
        }

        public Criteria andWechatUrlIsNotNull() {
            addCriterion("wechat_url is not null");
            return (Criteria) this;
        }

        public Criteria andWechatUrlEqualTo(String value) {
            addCriterion("wechat_url =", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotEqualTo(String value) {
            addCriterion("wechat_url <>", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlGreaterThan(String value) {
            addCriterion("wechat_url >", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_url >=", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlLessThan(String value) {
            addCriterion("wechat_url <", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlLessThanOrEqualTo(String value) {
            addCriterion("wechat_url <=", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlLike(String value) {
            addCriterion("wechat_url like", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotLike(String value) {
            addCriterion("wechat_url not like", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlIn(List<String> values) {
            addCriterion("wechat_url in", values, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotIn(List<String> values) {
            addCriterion("wechat_url not in", values, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlBetween(String value1, String value2) {
            addCriterion("wechat_url between", value1, value2, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotBetween(String value1, String value2) {
            addCriterion("wechat_url not between", value1, value2, "wechatUrl");
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