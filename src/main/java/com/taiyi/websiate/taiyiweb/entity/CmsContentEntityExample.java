package com.taiyi.websiate.taiyiweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsContentEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart;

    protected int limitEnd;

    protected String groupByClause;

    public CmsContentEntityExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andContentTitleIsNull() {
            addCriterion("content_title is null");
            return (Criteria) this;
        }

        public Criteria andContentTitleIsNotNull() {
            addCriterion("content_title is not null");
            return (Criteria) this;
        }

        public Criteria andContentTitleEqualTo(String value) {
            addCriterion("content_title =", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleNotEqualTo(String value) {
            addCriterion("content_title <>", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleGreaterThan(String value) {
            addCriterion("content_title >", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleGreaterThanOrEqualTo(String value) {
            addCriterion("content_title >=", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleLessThan(String value) {
            addCriterion("content_title <", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleLessThanOrEqualTo(String value) {
            addCriterion("content_title <=", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleLike(String value) {
            addCriterion("content_title like", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleNotLike(String value) {
            addCriterion("content_title not like", value, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleIn(List<String> values) {
            addCriterion("content_title in", values, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleNotIn(List<String> values) {
            addCriterion("content_title not in", values, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleBetween(String value1, String value2) {
            addCriterion("content_title between", value1, value2, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentTitleNotBetween(String value1, String value2) {
            addCriterion("content_title not between", value1, value2, "contentTitle");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdIsNull() {
            addCriterion("content_category_id is null");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdIsNotNull() {
            addCriterion("content_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdEqualTo(String value) {
            addCriterion("content_category_id =", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdNotEqualTo(String value) {
            addCriterion("content_category_id <>", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdGreaterThan(String value) {
            addCriterion("content_category_id >", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("content_category_id >=", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdLessThan(String value) {
            addCriterion("content_category_id <", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("content_category_id <=", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdLike(String value) {
            addCriterion("content_category_id like", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdNotLike(String value) {
            addCriterion("content_category_id not like", value, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdIn(List<String> values) {
            addCriterion("content_category_id in", values, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdNotIn(List<String> values) {
            addCriterion("content_category_id not in", values, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdBetween(String value1, String value2) {
            addCriterion("content_category_id between", value1, value2, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentCategoryIdNotBetween(String value1, String value2) {
            addCriterion("content_category_id not between", value1, value2, "contentCategoryId");
            return (Criteria) this;
        }

        public Criteria andContentUrlIsNull() {
            addCriterion("content_url is null");
            return (Criteria) this;
        }

        public Criteria andContentUrlIsNotNull() {
            addCriterion("content_url is not null");
            return (Criteria) this;
        }

        public Criteria andContentUrlEqualTo(String value) {
            addCriterion("content_url =", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotEqualTo(String value) {
            addCriterion("content_url <>", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlGreaterThan(String value) {
            addCriterion("content_url >", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlGreaterThanOrEqualTo(String value) {
            addCriterion("content_url >=", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLessThan(String value) {
            addCriterion("content_url <", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLessThanOrEqualTo(String value) {
            addCriterion("content_url <=", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLike(String value) {
            addCriterion("content_url like", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotLike(String value) {
            addCriterion("content_url not like", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlIn(List<String> values) {
            addCriterion("content_url in", values, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotIn(List<String> values) {
            addCriterion("content_url not in", values, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlBetween(String value1, String value2) {
            addCriterion("content_url between", value1, value2, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotBetween(String value1, String value2) {
            addCriterion("content_url not between", value1, value2, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentKeywordIsNull() {
            addCriterion("content_keyword is null");
            return (Criteria) this;
        }

        public Criteria andContentKeywordIsNotNull() {
            addCriterion("content_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andContentKeywordEqualTo(String value) {
            addCriterion("content_keyword =", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotEqualTo(String value) {
            addCriterion("content_keyword <>", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordGreaterThan(String value) {
            addCriterion("content_keyword >", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("content_keyword >=", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordLessThan(String value) {
            addCriterion("content_keyword <", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordLessThanOrEqualTo(String value) {
            addCriterion("content_keyword <=", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordLike(String value) {
            addCriterion("content_keyword like", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotLike(String value) {
            addCriterion("content_keyword not like", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordIn(List<String> values) {
            addCriterion("content_keyword in", values, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotIn(List<String> values) {
            addCriterion("content_keyword not in", values, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordBetween(String value1, String value2) {
            addCriterion("content_keyword between", value1, value2, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotBetween(String value1, String value2) {
            addCriterion("content_keyword not between", value1, value2, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionIsNull() {
            addCriterion("content_description is null");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionIsNotNull() {
            addCriterion("content_description is not null");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionEqualTo(String value) {
            addCriterion("content_description =", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionNotEqualTo(String value) {
            addCriterion("content_description <>", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionGreaterThan(String value) {
            addCriterion("content_description >", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("content_description >=", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionLessThan(String value) {
            addCriterion("content_description <", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionLessThanOrEqualTo(String value) {
            addCriterion("content_description <=", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionLike(String value) {
            addCriterion("content_description like", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionNotLike(String value) {
            addCriterion("content_description not like", value, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionIn(List<String> values) {
            addCriterion("content_description in", values, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionNotIn(List<String> values) {
            addCriterion("content_description not in", values, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionBetween(String value1, String value2) {
            addCriterion("content_description between", value1, value2, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentDescriptionNotBetween(String value1, String value2) {
            addCriterion("content_description not between", value1, value2, "contentDescription");
            return (Criteria) this;
        }

        public Criteria andContentImgIsNull() {
            addCriterion("content_img is null");
            return (Criteria) this;
        }

        public Criteria andContentImgIsNotNull() {
            addCriterion("content_img is not null");
            return (Criteria) this;
        }

        public Criteria andContentImgEqualTo(String value) {
            addCriterion("content_img =", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgNotEqualTo(String value) {
            addCriterion("content_img <>", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgGreaterThan(String value) {
            addCriterion("content_img >", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgGreaterThanOrEqualTo(String value) {
            addCriterion("content_img >=", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgLessThan(String value) {
            addCriterion("content_img <", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgLessThanOrEqualTo(String value) {
            addCriterion("content_img <=", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgLike(String value) {
            addCriterion("content_img like", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgNotLike(String value) {
            addCriterion("content_img not like", value, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgIn(List<String> values) {
            addCriterion("content_img in", values, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgNotIn(List<String> values) {
            addCriterion("content_img not in", values, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgBetween(String value1, String value2) {
            addCriterion("content_img between", value1, value2, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentImgNotBetween(String value1, String value2) {
            addCriterion("content_img not between", value1, value2, "contentImg");
            return (Criteria) this;
        }

        public Criteria andContentSortIsNull() {
            addCriterion("content_sort is null");
            return (Criteria) this;
        }

        public Criteria andContentSortIsNotNull() {
            addCriterion("content_sort is not null");
            return (Criteria) this;
        }

        public Criteria andContentSortEqualTo(Integer value) {
            addCriterion("content_sort =", value, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortNotEqualTo(Integer value) {
            addCriterion("content_sort <>", value, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortGreaterThan(Integer value) {
            addCriterion("content_sort >", value, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_sort >=", value, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortLessThan(Integer value) {
            addCriterion("content_sort <", value, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortLessThanOrEqualTo(Integer value) {
            addCriterion("content_sort <=", value, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortIn(List<Integer> values) {
            addCriterion("content_sort in", values, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortNotIn(List<Integer> values) {
            addCriterion("content_sort not in", values, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortBetween(Integer value1, Integer value2) {
            addCriterion("content_sort between", value1, value2, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentSortNotBetween(Integer value1, Integer value2) {
            addCriterion("content_sort not between", value1, value2, "contentSort");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeIsNull() {
            addCriterion("content_datetime is null");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeIsNotNull() {
            addCriterion("content_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeEqualTo(Date value) {
            addCriterion("content_datetime =", value, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeNotEqualTo(Date value) {
            addCriterion("content_datetime <>", value, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeGreaterThan(Date value) {
            addCriterion("content_datetime >", value, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("content_datetime >=", value, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeLessThan(Date value) {
            addCriterion("content_datetime <", value, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("content_datetime <=", value, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeIn(List<Date> values) {
            addCriterion("content_datetime in", values, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeNotIn(List<Date> values) {
            addCriterion("content_datetime not in", values, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeBetween(Date value1, Date value2) {
            addCriterion("content_datetime between", value1, value2, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("content_datetime not between", value1, value2, "contentDatetime");
            return (Criteria) this;
        }

        public Criteria andContentSourceIsNull() {
            addCriterion("content_source is null");
            return (Criteria) this;
        }

        public Criteria andContentSourceIsNotNull() {
            addCriterion("content_source is not null");
            return (Criteria) this;
        }

        public Criteria andContentSourceEqualTo(String value) {
            addCriterion("content_source =", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotEqualTo(String value) {
            addCriterion("content_source <>", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceGreaterThan(String value) {
            addCriterion("content_source >", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceGreaterThanOrEqualTo(String value) {
            addCriterion("content_source >=", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceLessThan(String value) {
            addCriterion("content_source <", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceLessThanOrEqualTo(String value) {
            addCriterion("content_source <=", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceLike(String value) {
            addCriterion("content_source like", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotLike(String value) {
            addCriterion("content_source not like", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceIn(List<String> values) {
            addCriterion("content_source in", values, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotIn(List<String> values) {
            addCriterion("content_source not in", values, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceBetween(String value1, String value2) {
            addCriterion("content_source between", value1, value2, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotBetween(String value1, String value2) {
            addCriterion("content_source not between", value1, value2, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentAuthorIsNull() {
            addCriterion("content_author is null");
            return (Criteria) this;
        }

        public Criteria andContentAuthorIsNotNull() {
            addCriterion("content_author is not null");
            return (Criteria) this;
        }

        public Criteria andContentAuthorEqualTo(String value) {
            addCriterion("content_author =", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorNotEqualTo(String value) {
            addCriterion("content_author <>", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorGreaterThan(String value) {
            addCriterion("content_author >", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("content_author >=", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorLessThan(String value) {
            addCriterion("content_author <", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorLessThanOrEqualTo(String value) {
            addCriterion("content_author <=", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorLike(String value) {
            addCriterion("content_author like", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorNotLike(String value) {
            addCriterion("content_author not like", value, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorIn(List<String> values) {
            addCriterion("content_author in", values, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorNotIn(List<String> values) {
            addCriterion("content_author not in", values, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorBetween(String value1, String value2) {
            addCriterion("content_author between", value1, value2, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentAuthorNotBetween(String value1, String value2) {
            addCriterion("content_author not between", value1, value2, "contentAuthor");
            return (Criteria) this;
        }

        public Criteria andContentDisplayIsNull() {
            addCriterion("content_display is null");
            return (Criteria) this;
        }

        public Criteria andContentDisplayIsNotNull() {
            addCriterion("content_display is not null");
            return (Criteria) this;
        }

        public Criteria andContentDisplayEqualTo(String value) {
            addCriterion("content_display =", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayNotEqualTo(String value) {
            addCriterion("content_display <>", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayGreaterThan(String value) {
            addCriterion("content_display >", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("content_display >=", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayLessThan(String value) {
            addCriterion("content_display <", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayLessThanOrEqualTo(String value) {
            addCriterion("content_display <=", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayLike(String value) {
            addCriterion("content_display like", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayNotLike(String value) {
            addCriterion("content_display not like", value, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayIn(List<String> values) {
            addCriterion("content_display in", values, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayNotIn(List<String> values) {
            addCriterion("content_display not in", values, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayBetween(String value1, String value2) {
            addCriterion("content_display between", value1, value2, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentDisplayNotBetween(String value1, String value2) {
            addCriterion("content_display not between", value1, value2, "contentDisplay");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(String value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(String value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(String value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(String value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(String value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLike(String value) {
            addCriterion("content_type like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotLike(String value) {
            addCriterion("content_type not like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<String> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<String> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(String value1, String value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(String value1, String value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentHitIsNull() {
            addCriterion("content_hit is null");
            return (Criteria) this;
        }

        public Criteria andContentHitIsNotNull() {
            addCriterion("content_hit is not null");
            return (Criteria) this;
        }

        public Criteria andContentHitEqualTo(Long value) {
            addCriterion("content_hit =", value, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitNotEqualTo(Long value) {
            addCriterion("content_hit <>", value, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitGreaterThan(Long value) {
            addCriterion("content_hit >", value, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitGreaterThanOrEqualTo(Long value) {
            addCriterion("content_hit >=", value, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitLessThan(Long value) {
            addCriterion("content_hit <", value, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitLessThanOrEqualTo(Long value) {
            addCriterion("content_hit <=", value, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitIn(List<Long> values) {
            addCriterion("content_hit in", values, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitNotIn(List<Long> values) {
            addCriterion("content_hit not in", values, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitBetween(Long value1, Long value2) {
            addCriterion("content_hit between", value1, value2, "contentHit");
            return (Criteria) this;
        }

        public Criteria andContentHitNotBetween(Long value1, Long value2) {
            addCriterion("content_hit not between", value1, value2, "contentHit");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Integer value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Integer value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Integer value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Integer value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Integer value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Integer> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Integer> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Integer value1, Integer value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Integer value1, Integer value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
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