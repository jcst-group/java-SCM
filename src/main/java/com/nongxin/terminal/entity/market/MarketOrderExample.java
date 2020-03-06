package com.nongxin.terminal.entity.market;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MarketOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketOrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNull() {
            addCriterion("contract_date is null");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNotNull() {
            addCriterion("contract_date is not null");
            return (Criteria) this;
        }

        public Criteria andContractDateEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date =", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date <>", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThan(Date value) {
            addCriterionForJDBCDate("contract_date >", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date >=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThan(Date value) {
            addCriterionForJDBCDate("contract_date <", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date <=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateIn(List<Date> values) {
            addCriterionForJDBCDate("contract_date in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("contract_date not in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contract_date between", value1, value2, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contract_date not between", value1, value2, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNull() {
            addCriterion("contract_code is null");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNotNull() {
            addCriterion("contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodeEqualTo(String value) {
            addCriterion("contract_code =", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotEqualTo(String value) {
            addCriterion("contract_code <>", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThan(String value) {
            addCriterion("contract_code >", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_code >=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThan(String value) {
            addCriterion("contract_code <", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThanOrEqualTo(String value) {
            addCriterion("contract_code <=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLike(String value) {
            addCriterion("contract_code like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotLike(String value) {
            addCriterion("contract_code not like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeIn(List<String> values) {
            addCriterion("contract_code in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotIn(List<String> values) {
            addCriterion("contract_code not in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeBetween(String value1, String value2) {
            addCriterion("contract_code between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotBetween(String value1, String value2) {
            addCriterion("contract_code not between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNull() {
            addCriterion("send_date is null");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNotNull() {
            addCriterion("send_date is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateEqualTo(Date value) {
            addCriterion("send_date =", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotEqualTo(Date value) {
            addCriterion("send_date <>", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThan(Date value) {
            addCriterion("send_date >", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("send_date >=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThan(Date value) {
            addCriterion("send_date <", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThanOrEqualTo(Date value) {
            addCriterion("send_date <=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateIn(List<Date> values) {
            addCriterion("send_date in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotIn(List<Date> values) {
            addCriterion("send_date not in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateBetween(Date value1, Date value2) {
            addCriterion("send_date between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotBetween(Date value1, Date value2) {
            addCriterion("send_date not between", value1, value2, "sendDate");
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

        public Criteria andSaleAmountIsNull() {
            addCriterion("sale_amount is null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIsNotNull() {
            addCriterion("sale_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountEqualTo(Integer value) {
            addCriterion("sale_amount =", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotEqualTo(Integer value) {
            addCriterion("sale_amount <>", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThan(Integer value) {
            addCriterion("sale_amount >", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_amount >=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThan(Integer value) {
            addCriterion("sale_amount <", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThanOrEqualTo(Integer value) {
            addCriterion("sale_amount <=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIn(List<Integer> values) {
            addCriterion("sale_amount in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotIn(List<Integer> values) {
            addCriterion("sale_amount not in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountBetween(Integer value1, Integer value2) {
            addCriterion("sale_amount between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_amount not between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(BigDecimal value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(BigDecimal value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(BigDecimal value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<BigDecimal> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSaleSumIsNull() {
            addCriterion("sale_sum is null");
            return (Criteria) this;
        }

        public Criteria andSaleSumIsNotNull() {
            addCriterion("sale_sum is not null");
            return (Criteria) this;
        }

        public Criteria andSaleSumEqualTo(BigDecimal value) {
            addCriterion("sale_sum =", value, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumNotEqualTo(BigDecimal value) {
            addCriterion("sale_sum <>", value, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumGreaterThan(BigDecimal value) {
            addCriterion("sale_sum >", value, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_sum >=", value, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumLessThan(BigDecimal value) {
            addCriterion("sale_sum <", value, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_sum <=", value, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumIn(List<BigDecimal> values) {
            addCriterion("sale_sum in", values, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumNotIn(List<BigDecimal> values) {
            addCriterion("sale_sum not in", values, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_sum between", value1, value2, "saleSum");
            return (Criteria) this;
        }

        public Criteria andSaleSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_sum not between", value1, value2, "saleSum");
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