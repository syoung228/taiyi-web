package com.taiyi.websiate.taiyiweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsCategoryEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart;

    protected int limitEnd;

    protected String groupByClause;

    public CmsCategoryEntityExample() {
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

        public Criteria andCategoryTitleIsNull() {
            addCriterion("category_title is null");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleIsNotNull() {
            addCriterion("category_title is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleEqualTo(String value) {
            addCriterion("category_title =", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotEqualTo(String value) {
            addCriterion("category_title <>", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleGreaterThan(String value) {
            addCriterion("category_title >", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleGreaterThanOrEqualTo(String value) {
            addCriterion("category_title >=", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleLessThan(String value) {
            addCriterion("category_title <", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleLessThanOrEqualTo(String value) {
            addCriterion("category_title <=", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleLike(String value) {
            addCriterion("category_title like", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotLike(String value) {
            addCriterion("category_title not like", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleIn(List<String> values) {
            addCriterion("category_title in", values, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotIn(List<String> values) {
            addCriterion("category_title not in", values, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleBetween(String value1, String value2) {
            addCriterion("category_title between", value1, value2, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotBetween(String value1, String value2) {
            addCriterion("category_title not between", value1, value2, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryImgIsNull() {
            addCriterion("category_img is null");
            return (Criteria) this;
        }

        public Criteria andCategoryImgIsNotNull() {
            addCriterion("category_img is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryImgEqualTo(String value) {
            addCriterion("category_img =", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotEqualTo(String value) {
            addCriterion("category_img <>", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgGreaterThan(String value) {
            addCriterion("category_img >", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgGreaterThanOrEqualTo(String value) {
            addCriterion("category_img >=", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgLessThan(String value) {
            addCriterion("category_img <", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgLessThanOrEqualTo(String value) {
            addCriterion("category_img <=", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgLike(String value) {
            addCriterion("category_img like", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotLike(String value) {
            addCriterion("category_img not like", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgIn(List<String> values) {
            addCriterion("category_img in", values, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotIn(List<String> values) {
            addCriterion("category_img not in", values, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgBetween(String value1, String value2) {
            addCriterion("category_img between", value1, value2, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotBetween(String value1, String value2) {
            addCriterion("category_img not between", value1, value2, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagIsNull() {
            addCriterion("category_flag is null");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagIsNotNull() {
            addCriterion("category_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagEqualTo(String value) {
            addCriterion("category_flag =", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagNotEqualTo(String value) {
            addCriterion("category_flag <>", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagGreaterThan(String value) {
            addCriterion("category_flag >", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagGreaterThanOrEqualTo(String value) {
            addCriterion("category_flag >=", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagLessThan(String value) {
            addCriterion("category_flag <", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagLessThanOrEqualTo(String value) {
            addCriterion("category_flag <=", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagLike(String value) {
            addCriterion("category_flag like", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagNotLike(String value) {
            addCriterion("category_flag not like", value, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagIn(List<String> values) {
            addCriterion("category_flag in", values, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagNotIn(List<String> values) {
            addCriterion("category_flag not in", values, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagBetween(String value1, String value2) {
            addCriterion("category_flag between", value1, value2, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryFlagNotBetween(String value1, String value2) {
            addCriterion("category_flag not between", value1, value2, "categoryFlag");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripIsNull() {
            addCriterion("category_descrip is null");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripIsNotNull() {
            addCriterion("category_descrip is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripEqualTo(String value) {
            addCriterion("category_descrip =", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripNotEqualTo(String value) {
            addCriterion("category_descrip <>", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripGreaterThan(String value) {
            addCriterion("category_descrip >", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripGreaterThanOrEqualTo(String value) {
            addCriterion("category_descrip >=", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripLessThan(String value) {
            addCriterion("category_descrip <", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripLessThanOrEqualTo(String value) {
            addCriterion("category_descrip <=", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripLike(String value) {
            addCriterion("category_descrip like", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripNotLike(String value) {
            addCriterion("category_descrip not like", value, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripIn(List<String> values) {
            addCriterion("category_descrip in", values, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripNotIn(List<String> values) {
            addCriterion("category_descrip not in", values, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripBetween(String value1, String value2) {
            addCriterion("category_descrip between", value1, value2, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryDescripNotBetween(String value1, String value2) {
            addCriterion("category_descrip not between", value1, value2, "categoryDescrip");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordIsNull() {
            addCriterion("category_keyword is null");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordIsNotNull() {
            addCriterion("category_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordEqualTo(String value) {
            addCriterion("category_keyword =", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordNotEqualTo(String value) {
            addCriterion("category_keyword <>", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordGreaterThan(String value) {
            addCriterion("category_keyword >", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("category_keyword >=", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordLessThan(String value) {
            addCriterion("category_keyword <", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordLessThanOrEqualTo(String value) {
            addCriterion("category_keyword <=", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordLike(String value) {
            addCriterion("category_keyword like", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordNotLike(String value) {
            addCriterion("category_keyword not like", value, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordIn(List<String> values) {
            addCriterion("category_keyword in", values, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordNotIn(List<String> values) {
            addCriterion("category_keyword not in", values, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordBetween(String value1, String value2) {
            addCriterion("category_keyword between", value1, value2, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryKeywordNotBetween(String value1, String value2) {
            addCriterion("category_keyword not between", value1, value2, "categoryKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryPathIsNull() {
            addCriterion("category_path is null");
            return (Criteria) this;
        }

        public Criteria andCategoryPathIsNotNull() {
            addCriterion("category_path is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryPathEqualTo(String value) {
            addCriterion("category_path =", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathNotEqualTo(String value) {
            addCriterion("category_path <>", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathGreaterThan(String value) {
            addCriterion("category_path >", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathGreaterThanOrEqualTo(String value) {
            addCriterion("category_path >=", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathLessThan(String value) {
            addCriterion("category_path <", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathLessThanOrEqualTo(String value) {
            addCriterion("category_path <=", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathLike(String value) {
            addCriterion("category_path like", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathNotLike(String value) {
            addCriterion("category_path not like", value, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathIn(List<String> values) {
            addCriterion("category_path in", values, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathNotIn(List<String> values) {
            addCriterion("category_path not in", values, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathBetween(String value1, String value2) {
            addCriterion("category_path between", value1, value2, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryPathNotBetween(String value1, String value2) {
            addCriterion("category_path not between", value1, value2, "categoryPath");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIsNull() {
            addCriterion("category_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIsNotNull() {
            addCriterion("category_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdEqualTo(String value) {
            addCriterion("category_parent_id =", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotEqualTo(String value) {
            addCriterion("category_parent_id <>", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdGreaterThan(String value) {
            addCriterion("category_parent_id >", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_parent_id >=", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdLessThan(String value) {
            addCriterion("category_parent_id <", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdLessThanOrEqualTo(String value) {
            addCriterion("category_parent_id <=", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdLike(String value) {
            addCriterion("category_parent_id like", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotLike(String value) {
            addCriterion("category_parent_id not like", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIn(List<String> values) {
            addCriterion("category_parent_id in", values, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotIn(List<String> values) {
            addCriterion("category_parent_id not in", values, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdBetween(String value1, String value2) {
            addCriterion("category_parent_id between", value1, value2, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotBetween(String value1, String value2) {
            addCriterion("category_parent_id not between", value1, value2, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andDictIdIsNull() {
            addCriterion("dict_id is null");
            return (Criteria) this;
        }

        public Criteria andDictIdIsNotNull() {
            addCriterion("dict_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictIdEqualTo(Integer value) {
            addCriterion("dict_id =", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotEqualTo(Integer value) {
            addCriterion("dict_id <>", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThan(Integer value) {
            addCriterion("dict_id >", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dict_id >=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThan(Integer value) {
            addCriterion("dict_id <", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThanOrEqualTo(Integer value) {
            addCriterion("dict_id <=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdIn(List<Integer> values) {
            addCriterion("dict_id in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotIn(List<Integer> values) {
            addCriterion("dict_id not in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdBetween(Integer value1, Integer value2) {
            addCriterion("dict_id between", value1, value2, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dict_id not between", value1, value2, "dictId");
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

        public Criteria andCategoryManagerIdIsNull() {
            addCriterion("category_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdIsNotNull() {
            addCriterion("category_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdEqualTo(Integer value) {
            addCriterion("category_manager_id =", value, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdNotEqualTo(Integer value) {
            addCriterion("category_manager_id <>", value, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdGreaterThan(Integer value) {
            addCriterion("category_manager_id >", value, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_manager_id >=", value, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdLessThan(Integer value) {
            addCriterion("category_manager_id <", value, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_manager_id <=", value, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdIn(List<Integer> values) {
            addCriterion("category_manager_id in", values, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdNotIn(List<Integer> values) {
            addCriterion("category_manager_id not in", values, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("category_manager_id between", value1, value2, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_manager_id not between", value1, value2, "categoryManagerId");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeIsNull() {
            addCriterion("category_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeIsNotNull() {
            addCriterion("category_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeEqualTo(Date value) {
            addCriterion("category_datetime =", value, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeNotEqualTo(Date value) {
            addCriterion("category_datetime <>", value, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeGreaterThan(Date value) {
            addCriterion("category_datetime >", value, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("category_datetime >=", value, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeLessThan(Date value) {
            addCriterion("category_datetime <", value, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("category_datetime <=", value, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeIn(List<Date> values) {
            addCriterion("category_datetime in", values, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeNotIn(List<Date> values) {
            addCriterion("category_datetime not in", values, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeBetween(Date value1, Date value2) {
            addCriterion("category_datetime between", value1, value2, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andCategoryDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("category_datetime not between", value1, value2, "categoryDatetime");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdIsNull() {
            addCriterion("mdiy_model_id is null");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdIsNotNull() {
            addCriterion("mdiy_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdEqualTo(String value) {
            addCriterion("mdiy_model_id =", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdNotEqualTo(String value) {
            addCriterion("mdiy_model_id <>", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdGreaterThan(String value) {
            addCriterion("mdiy_model_id >", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("mdiy_model_id >=", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdLessThan(String value) {
            addCriterion("mdiy_model_id <", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdLessThanOrEqualTo(String value) {
            addCriterion("mdiy_model_id <=", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdLike(String value) {
            addCriterion("mdiy_model_id like", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdNotLike(String value) {
            addCriterion("mdiy_model_id not like", value, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdIn(List<String> values) {
            addCriterion("mdiy_model_id in", values, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdNotIn(List<String> values) {
            addCriterion("mdiy_model_id not in", values, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdBetween(String value1, String value2) {
            addCriterion("mdiy_model_id between", value1, value2, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andMdiyModelIdNotBetween(String value1, String value2) {
            addCriterion("mdiy_model_id not between", value1, value2, "mdiyModelId");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlIsNull() {
            addCriterion("category_diy_url is null");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlIsNotNull() {
            addCriterion("category_diy_url is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlEqualTo(String value) {
            addCriterion("category_diy_url =", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlNotEqualTo(String value) {
            addCriterion("category_diy_url <>", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlGreaterThan(String value) {
            addCriterion("category_diy_url >", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("category_diy_url >=", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlLessThan(String value) {
            addCriterion("category_diy_url <", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlLessThanOrEqualTo(String value) {
            addCriterion("category_diy_url <=", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlLike(String value) {
            addCriterion("category_diy_url like", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlNotLike(String value) {
            addCriterion("category_diy_url not like", value, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlIn(List<String> values) {
            addCriterion("category_diy_url in", values, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlNotIn(List<String> values) {
            addCriterion("category_diy_url not in", values, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlBetween(String value1, String value2) {
            addCriterion("category_diy_url between", value1, value2, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryDiyUrlNotBetween(String value1, String value2) {
            addCriterion("category_diy_url not between", value1, value2, "categoryDiyUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNull() {
            addCriterion("category_url is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNotNull() {
            addCriterion("category_url is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlEqualTo(String value) {
            addCriterion("category_url =", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotEqualTo(String value) {
            addCriterion("category_url <>", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlGreaterThan(String value) {
            addCriterion("category_url >", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlGreaterThanOrEqualTo(String value) {
            addCriterion("category_url >=", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThan(String value) {
            addCriterion("category_url <", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThanOrEqualTo(String value) {
            addCriterion("category_url <=", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLike(String value) {
            addCriterion("category_url like", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotLike(String value) {
            addCriterion("category_url not like", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIn(List<String> values) {
            addCriterion("category_url in", values, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotIn(List<String> values) {
            addCriterion("category_url not in", values, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlBetween(String value1, String value2) {
            addCriterion("category_url between", value1, value2, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotBetween(String value1, String value2) {
            addCriterion("category_url not between", value1, value2, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlIsNull() {
            addCriterion("category_list_url is null");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlIsNotNull() {
            addCriterion("category_list_url is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlEqualTo(String value) {
            addCriterion("category_list_url =", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlNotEqualTo(String value) {
            addCriterion("category_list_url <>", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlGreaterThan(String value) {
            addCriterion("category_list_url >", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlGreaterThanOrEqualTo(String value) {
            addCriterion("category_list_url >=", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlLessThan(String value) {
            addCriterion("category_list_url <", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlLessThanOrEqualTo(String value) {
            addCriterion("category_list_url <=", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlLike(String value) {
            addCriterion("category_list_url like", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlNotLike(String value) {
            addCriterion("category_list_url not like", value, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlIn(List<String> values) {
            addCriterion("category_list_url in", values, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlNotIn(List<String> values) {
            addCriterion("category_list_url not in", values, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlBetween(String value1, String value2) {
            addCriterion("category_list_url between", value1, value2, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryListUrlNotBetween(String value1, String value2) {
            addCriterion("category_list_url not between", value1, value2, "categoryListUrl");
            return (Criteria) this;
        }

        public Criteria andCategorySortIsNull() {
            addCriterion("category_sort is null");
            return (Criteria) this;
        }

        public Criteria andCategorySortIsNotNull() {
            addCriterion("category_sort is not null");
            return (Criteria) this;
        }

        public Criteria andCategorySortEqualTo(Integer value) {
            addCriterion("category_sort =", value, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortNotEqualTo(Integer value) {
            addCriterion("category_sort <>", value, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortGreaterThan(Integer value) {
            addCriterion("category_sort >", value, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_sort >=", value, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortLessThan(Integer value) {
            addCriterion("category_sort <", value, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortLessThanOrEqualTo(Integer value) {
            addCriterion("category_sort <=", value, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortIn(List<Integer> values) {
            addCriterion("category_sort in", values, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortNotIn(List<Integer> values) {
            addCriterion("category_sort not in", values, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortBetween(Integer value1, Integer value2) {
            addCriterion("category_sort between", value1, value2, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategorySortNotBetween(Integer value1, Integer value2) {
            addCriterion("category_sort not between", value1, value2, "categorySort");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIsNull() {
            addCriterion("category_type is null");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIsNotNull() {
            addCriterion("category_type is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeEqualTo(String value) {
            addCriterion("category_type =", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotEqualTo(String value) {
            addCriterion("category_type <>", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeGreaterThan(String value) {
            addCriterion("category_type >", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("category_type >=", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLessThan(String value) {
            addCriterion("category_type <", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLessThanOrEqualTo(String value) {
            addCriterion("category_type <=", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLike(String value) {
            addCriterion("category_type like", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotLike(String value) {
            addCriterion("category_type not like", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIn(List<String> values) {
            addCriterion("category_type in", values, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotIn(List<String> values) {
            addCriterion("category_type not in", values, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeBetween(String value1, String value2) {
            addCriterion("category_type between", value1, value2, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotBetween(String value1, String value2) {
            addCriterion("category_type not between", value1, value2, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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