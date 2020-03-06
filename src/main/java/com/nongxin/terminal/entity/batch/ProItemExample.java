package com.nongxin.terminal.entity.batch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProItemExample() {
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

        public Criteria andInitproBatchIdIsNull() {
            addCriterion("initpro_batch_id is null");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdIsNotNull() {
            addCriterion("initpro_batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdEqualTo(Integer value) {
            addCriterion("initpro_batch_id =", value, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdNotEqualTo(Integer value) {
            addCriterion("initpro_batch_id <>", value, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdGreaterThan(Integer value) {
            addCriterion("initpro_batch_id >", value, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("initpro_batch_id >=", value, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdLessThan(Integer value) {
            addCriterion("initpro_batch_id <", value, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("initpro_batch_id <=", value, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdIn(List<Integer> values) {
            addCriterion("initpro_batch_id in", values, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdNotIn(List<Integer> values) {
            addCriterion("initpro_batch_id not in", values, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdBetween(Integer value1, Integer value2) {
            addCriterion("initpro_batch_id between", value1, value2, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andInitproBatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("initpro_batch_id not between", value1, value2, "initproBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdIsNull() {
            addCriterion("revocery_batch_id is null");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdIsNotNull() {
            addCriterion("revocery_batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdEqualTo(Integer value) {
            addCriterion("revocery_batch_id =", value, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdNotEqualTo(Integer value) {
            addCriterion("revocery_batch_id <>", value, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdGreaterThan(Integer value) {
            addCriterion("revocery_batch_id >", value, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("revocery_batch_id >=", value, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdLessThan(Integer value) {
            addCriterion("revocery_batch_id <", value, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("revocery_batch_id <=", value, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdIn(List<Integer> values) {
            addCriterion("revocery_batch_id in", values, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdNotIn(List<Integer> values) {
            addCriterion("revocery_batch_id not in", values, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdBetween(Integer value1, Integer value2) {
            addCriterion("revocery_batch_id between", value1, value2, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andRevoceryBatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("revocery_batch_id not between", value1, value2, "revoceryBatchId");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProLevelIsNull() {
            addCriterion("pro_level is null");
            return (Criteria) this;
        }

        public Criteria andProLevelIsNotNull() {
            addCriterion("pro_level is not null");
            return (Criteria) this;
        }

        public Criteria andProLevelEqualTo(String value) {
            addCriterion("pro_level =", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotEqualTo(String value) {
            addCriterion("pro_level <>", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelGreaterThan(String value) {
            addCriterion("pro_level >", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelGreaterThanOrEqualTo(String value) {
            addCriterion("pro_level >=", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLessThan(String value) {
            addCriterion("pro_level <", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLessThanOrEqualTo(String value) {
            addCriterion("pro_level <=", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLike(String value) {
            addCriterion("pro_level like", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotLike(String value) {
            addCriterion("pro_level not like", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelIn(List<String> values) {
            addCriterion("pro_level in", values, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotIn(List<String> values) {
            addCriterion("pro_level not in", values, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelBetween(String value1, String value2) {
            addCriterion("pro_level between", value1, value2, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotBetween(String value1, String value2) {
            addCriterion("pro_level not between", value1, value2, "proLevel");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(BigDecimal value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(BigDecimal value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(BigDecimal value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(BigDecimal value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<BigDecimal> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<BigDecimal> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count not between", value1, value2, "count");
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