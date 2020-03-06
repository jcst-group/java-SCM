package com.nongxin.terminal.entity.market;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MarketGoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketGoodExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andPicSrcIsNull() {
            addCriterion("pic_src is null");
            return (Criteria) this;
        }

        public Criteria andPicSrcIsNotNull() {
            addCriterion("pic_src is not null");
            return (Criteria) this;
        }

        public Criteria andPicSrcEqualTo(String value) {
            addCriterion("pic_src =", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotEqualTo(String value) {
            addCriterion("pic_src <>", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcGreaterThan(String value) {
            addCriterion("pic_src >", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcGreaterThanOrEqualTo(String value) {
            addCriterion("pic_src >=", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLessThan(String value) {
            addCriterion("pic_src <", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLessThanOrEqualTo(String value) {
            addCriterion("pic_src <=", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLike(String value) {
            addCriterion("pic_src like", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotLike(String value) {
            addCriterion("pic_src not like", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcIn(List<String> values) {
            addCriterion("pic_src in", values, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotIn(List<String> values) {
            addCriterion("pic_src not in", values, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcBetween(String value1, String value2) {
            addCriterion("pic_src between", value1, value2, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotBetween(String value1, String value2) {
            addCriterion("pic_src not between", value1, value2, "picSrc");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNull() {
            addCriterion("good_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("good_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("good_name =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("good_name <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("good_name >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_name >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("good_name <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("good_name <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("good_name like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("good_name not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("good_name in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("good_name not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("good_name between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("good_name not between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("good_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("good_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceEqualTo(BigDecimal value) {
            addCriterion("good_price =", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotEqualTo(BigDecimal value) {
            addCriterion("good_price <>", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThan(BigDecimal value) {
            addCriterion("good_price >", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price >=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThan(BigDecimal value) {
            addCriterion("good_price <", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price <=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIn(List<BigDecimal> values) {
            addCriterion("good_price in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotIn(List<BigDecimal> values) {
            addCriterion("good_price not in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price not between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andSpecisIsNull() {
            addCriterion("specis is null");
            return (Criteria) this;
        }

        public Criteria andSpecisIsNotNull() {
            addCriterion("specis is not null");
            return (Criteria) this;
        }

        public Criteria andSpecisEqualTo(String value) {
            addCriterion("specis =", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisNotEqualTo(String value) {
            addCriterion("specis <>", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisGreaterThan(String value) {
            addCriterion("specis >", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisGreaterThanOrEqualTo(String value) {
            addCriterion("specis >=", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisLessThan(String value) {
            addCriterion("specis <", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisLessThanOrEqualTo(String value) {
            addCriterion("specis <=", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisLike(String value) {
            addCriterion("specis like", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisNotLike(String value) {
            addCriterion("specis not like", value, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisIn(List<String> values) {
            addCriterion("specis in", values, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisNotIn(List<String> values) {
            addCriterion("specis not in", values, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisBetween(String value1, String value2) {
            addCriterion("specis between", value1, value2, "specis");
            return (Criteria) this;
        }

        public Criteria andSpecisNotBetween(String value1, String value2) {
            addCriterion("specis not between", value1, value2, "specis");
            return (Criteria) this;
        }

        public Criteria andFromSourceIsNull() {
            addCriterion("from_source is null");
            return (Criteria) this;
        }

        public Criteria andFromSourceIsNotNull() {
            addCriterion("from_source is not null");
            return (Criteria) this;
        }

        public Criteria andFromSourceEqualTo(String value) {
            addCriterion("from_source =", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceNotEqualTo(String value) {
            addCriterion("from_source <>", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceGreaterThan(String value) {
            addCriterion("from_source >", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceGreaterThanOrEqualTo(String value) {
            addCriterion("from_source >=", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceLessThan(String value) {
            addCriterion("from_source <", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceLessThanOrEqualTo(String value) {
            addCriterion("from_source <=", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceLike(String value) {
            addCriterion("from_source like", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceNotLike(String value) {
            addCriterion("from_source not like", value, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceIn(List<String> values) {
            addCriterion("from_source in", values, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceNotIn(List<String> values) {
            addCriterion("from_source not in", values, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceBetween(String value1, String value2) {
            addCriterion("from_source between", value1, value2, "fromSource");
            return (Criteria) this;
        }

        public Criteria andFromSourceNotBetween(String value1, String value2) {
            addCriterion("from_source not between", value1, value2, "fromSource");
            return (Criteria) this;
        }

        public Criteria andGoodLevelIsNull() {
            addCriterion("good_level is null");
            return (Criteria) this;
        }

        public Criteria andGoodLevelIsNotNull() {
            addCriterion("good_level is not null");
            return (Criteria) this;
        }

        public Criteria andGoodLevelEqualTo(String value) {
            addCriterion("good_level =", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelNotEqualTo(String value) {
            addCriterion("good_level <>", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelGreaterThan(String value) {
            addCriterion("good_level >", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelGreaterThanOrEqualTo(String value) {
            addCriterion("good_level >=", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelLessThan(String value) {
            addCriterion("good_level <", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelLessThanOrEqualTo(String value) {
            addCriterion("good_level <=", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelLike(String value) {
            addCriterion("good_level like", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelNotLike(String value) {
            addCriterion("good_level not like", value, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelIn(List<String> values) {
            addCriterion("good_level in", values, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelNotIn(List<String> values) {
            addCriterion("good_level not in", values, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelBetween(String value1, String value2) {
            addCriterion("good_level between", value1, value2, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andGoodLevelNotBetween(String value1, String value2) {
            addCriterion("good_level not between", value1, value2, "goodLevel");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andSaveOneIsNull() {
            addCriterion("save_one is null");
            return (Criteria) this;
        }

        public Criteria andSaveOneIsNotNull() {
            addCriterion("save_one is not null");
            return (Criteria) this;
        }

        public Criteria andSaveOneEqualTo(BigDecimal value) {
            addCriterion("save_one =", value, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneNotEqualTo(BigDecimal value) {
            addCriterion("save_one <>", value, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneGreaterThan(BigDecimal value) {
            addCriterion("save_one >", value, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("save_one >=", value, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneLessThan(BigDecimal value) {
            addCriterion("save_one <", value, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("save_one <=", value, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneIn(List<BigDecimal> values) {
            addCriterion("save_one in", values, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneNotIn(List<BigDecimal> values) {
            addCriterion("save_one not in", values, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("save_one between", value1, value2, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveOneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("save_one not between", value1, value2, "saveOne");
            return (Criteria) this;
        }

        public Criteria andSaveTwoIsNull() {
            addCriterion("save_two is null");
            return (Criteria) this;
        }

        public Criteria andSaveTwoIsNotNull() {
            addCriterion("save_two is not null");
            return (Criteria) this;
        }

        public Criteria andSaveTwoEqualTo(BigDecimal value) {
            addCriterion("save_two =", value, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoNotEqualTo(BigDecimal value) {
            addCriterion("save_two <>", value, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoGreaterThan(BigDecimal value) {
            addCriterion("save_two >", value, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("save_two >=", value, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoLessThan(BigDecimal value) {
            addCriterion("save_two <", value, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("save_two <=", value, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoIn(List<BigDecimal> values) {
            addCriterion("save_two in", values, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoNotIn(List<BigDecimal> values) {
            addCriterion("save_two not in", values, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("save_two between", value1, value2, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andSaveTwoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("save_two not between", value1, value2, "saveTwo");
            return (Criteria) this;
        }

        public Criteria andCharOneIsNull() {
            addCriterion("char_one is null");
            return (Criteria) this;
        }

        public Criteria andCharOneIsNotNull() {
            addCriterion("char_one is not null");
            return (Criteria) this;
        }

        public Criteria andCharOneEqualTo(String value) {
            addCriterion("char_one =", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneNotEqualTo(String value) {
            addCriterion("char_one <>", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneGreaterThan(String value) {
            addCriterion("char_one >", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneGreaterThanOrEqualTo(String value) {
            addCriterion("char_one >=", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneLessThan(String value) {
            addCriterion("char_one <", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneLessThanOrEqualTo(String value) {
            addCriterion("char_one <=", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneLike(String value) {
            addCriterion("char_one like", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneNotLike(String value) {
            addCriterion("char_one not like", value, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneIn(List<String> values) {
            addCriterion("char_one in", values, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneNotIn(List<String> values) {
            addCriterion("char_one not in", values, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneBetween(String value1, String value2) {
            addCriterion("char_one between", value1, value2, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharOneNotBetween(String value1, String value2) {
            addCriterion("char_one not between", value1, value2, "charOne");
            return (Criteria) this;
        }

        public Criteria andCharTwoIsNull() {
            addCriterion("char_two is null");
            return (Criteria) this;
        }

        public Criteria andCharTwoIsNotNull() {
            addCriterion("char_two is not null");
            return (Criteria) this;
        }

        public Criteria andCharTwoEqualTo(String value) {
            addCriterion("char_two =", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoNotEqualTo(String value) {
            addCriterion("char_two <>", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoGreaterThan(String value) {
            addCriterion("char_two >", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoGreaterThanOrEqualTo(String value) {
            addCriterion("char_two >=", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoLessThan(String value) {
            addCriterion("char_two <", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoLessThanOrEqualTo(String value) {
            addCriterion("char_two <=", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoLike(String value) {
            addCriterion("char_two like", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoNotLike(String value) {
            addCriterion("char_two not like", value, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoIn(List<String> values) {
            addCriterion("char_two in", values, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoNotIn(List<String> values) {
            addCriterion("char_two not in", values, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoBetween(String value1, String value2) {
            addCriterion("char_two between", value1, value2, "charTwo");
            return (Criteria) this;
        }

        public Criteria andCharTwoNotBetween(String value1, String value2) {
            addCriterion("char_two not between", value1, value2, "charTwo");
            return (Criteria) this;
        }

        public Criteria andIdOneIsNull() {
            addCriterion("id_one is null");
            return (Criteria) this;
        }

        public Criteria andIdOneIsNotNull() {
            addCriterion("id_one is not null");
            return (Criteria) this;
        }

        public Criteria andIdOneEqualTo(Integer value) {
            addCriterion("id_one =", value, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneNotEqualTo(Integer value) {
            addCriterion("id_one <>", value, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneGreaterThan(Integer value) {
            addCriterion("id_one >", value, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_one >=", value, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneLessThan(Integer value) {
            addCriterion("id_one <", value, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneLessThanOrEqualTo(Integer value) {
            addCriterion("id_one <=", value, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneIn(List<Integer> values) {
            addCriterion("id_one in", values, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneNotIn(List<Integer> values) {
            addCriterion("id_one not in", values, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneBetween(Integer value1, Integer value2) {
            addCriterion("id_one between", value1, value2, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdOneNotBetween(Integer value1, Integer value2) {
            addCriterion("id_one not between", value1, value2, "idOne");
            return (Criteria) this;
        }

        public Criteria andIdTwoIsNull() {
            addCriterion("id_two is null");
            return (Criteria) this;
        }

        public Criteria andIdTwoIsNotNull() {
            addCriterion("id_two is not null");
            return (Criteria) this;
        }

        public Criteria andIdTwoEqualTo(Integer value) {
            addCriterion("id_two =", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoNotEqualTo(Integer value) {
            addCriterion("id_two <>", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoGreaterThan(Integer value) {
            addCriterion("id_two >", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_two >=", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoLessThan(Integer value) {
            addCriterion("id_two <", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoLessThanOrEqualTo(Integer value) {
            addCriterion("id_two <=", value, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoIn(List<Integer> values) {
            addCriterion("id_two in", values, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoNotIn(List<Integer> values) {
            addCriterion("id_two not in", values, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoBetween(Integer value1, Integer value2) {
            addCriterion("id_two between", value1, value2, "idTwo");
            return (Criteria) this;
        }

        public Criteria andIdTwoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_two not between", value1, value2, "idTwo");
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