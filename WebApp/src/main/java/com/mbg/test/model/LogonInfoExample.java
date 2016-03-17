package com.mbg.test.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogonInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public LogonInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andLogonTypeIsNull() {
            addCriterion("logon_type is null");
            return (Criteria) this;
        }

        public Criteria andLogonTypeIsNotNull() {
            addCriterion("logon_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogonTypeEqualTo(String value) {
            addCriterion("logon_type =", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeNotEqualTo(String value) {
            addCriterion("logon_type <>", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeGreaterThan(String value) {
            addCriterion("logon_type >", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("logon_type >=", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeLessThan(String value) {
            addCriterion("logon_type <", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeLessThanOrEqualTo(String value) {
            addCriterion("logon_type <=", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeLike(String value) {
            addCriterion("logon_type like", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeNotLike(String value) {
            addCriterion("logon_type not like", value, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeIn(List<String> values) {
            addCriterion("logon_type in", values, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeNotIn(List<String> values) {
            addCriterion("logon_type not in", values, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeBetween(String value1, String value2) {
            addCriterion("logon_type between", value1, value2, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonTypeNotBetween(String value1, String value2) {
            addCriterion("logon_type not between", value1, value2, "logonType");
            return (Criteria) this;
        }

        public Criteria andLogonNameIsNull() {
            addCriterion("logon_name is null");
            return (Criteria) this;
        }

        public Criteria andLogonNameIsNotNull() {
            addCriterion("logon_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogonNameEqualTo(String value) {
            addCriterion("logon_name =", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameNotEqualTo(String value) {
            addCriterion("logon_name <>", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameGreaterThan(String value) {
            addCriterion("logon_name >", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameGreaterThanOrEqualTo(String value) {
            addCriterion("logon_name >=", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameLessThan(String value) {
            addCriterion("logon_name <", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameLessThanOrEqualTo(String value) {
            addCriterion("logon_name <=", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameLike(String value) {
            addCriterion("logon_name like", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameNotLike(String value) {
            addCriterion("logon_name not like", value, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameIn(List<String> values) {
            addCriterion("logon_name in", values, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameNotIn(List<String> values) {
            addCriterion("logon_name not in", values, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameBetween(String value1, String value2) {
            addCriterion("logon_name between", value1, value2, "logonName");
            return (Criteria) this;
        }

        public Criteria andLogonNameNotBetween(String value1, String value2) {
            addCriterion("logon_name not between", value1, value2, "logonName");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIsNull() {
            addCriterion("verify_code is null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIsNotNull() {
            addCriterion("verify_code is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeEqualTo(String value) {
            addCriterion("verify_code =", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotEqualTo(String value) {
            addCriterion("verify_code <>", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThan(String value) {
            addCriterion("verify_code >", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("verify_code >=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThan(String value) {
            addCriterion("verify_code <", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThanOrEqualTo(String value) {
            addCriterion("verify_code <=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLike(String value) {
            addCriterion("verify_code like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotLike(String value) {
            addCriterion("verify_code not like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIn(List<String> values) {
            addCriterion("verify_code in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotIn(List<String> values) {
            addCriterion("verify_code not in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeBetween(String value1, String value2) {
            addCriterion("verify_code between", value1, value2, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotBetween(String value1, String value2) {
            addCriterion("verify_code not between", value1, value2, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusUuidIsNull() {
            addCriterion("status_uuid is null");
            return (Criteria) this;
        }

        public Criteria andStatusUuidIsNotNull() {
            addCriterion("status_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andStatusUuidEqualTo(String value) {
            addCriterion("status_uuid =", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidNotEqualTo(String value) {
            addCriterion("status_uuid <>", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidGreaterThan(String value) {
            addCriterion("status_uuid >", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidGreaterThanOrEqualTo(String value) {
            addCriterion("status_uuid >=", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidLessThan(String value) {
            addCriterion("status_uuid <", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidLessThanOrEqualTo(String value) {
            addCriterion("status_uuid <=", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidLike(String value) {
            addCriterion("status_uuid like", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidNotLike(String value) {
            addCriterion("status_uuid not like", value, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidIn(List<String> values) {
            addCriterion("status_uuid in", values, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidNotIn(List<String> values) {
            addCriterion("status_uuid not in", values, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidBetween(String value1, String value2) {
            addCriterion("status_uuid between", value1, value2, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andStatusUuidNotBetween(String value1, String value2) {
            addCriterion("status_uuid not between", value1, value2, "statusUuid");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpIsNull() {
            addCriterion("gmt_verify_exp is null");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpIsNotNull() {
            addCriterion("gmt_verify_exp is not null");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpEqualTo(Date value) {
            addCriterion("gmt_verify_exp =", value, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpNotEqualTo(Date value) {
            addCriterion("gmt_verify_exp <>", value, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpGreaterThan(Date value) {
            addCriterion("gmt_verify_exp >", value, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_verify_exp >=", value, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpLessThan(Date value) {
            addCriterion("gmt_verify_exp <", value, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpLessThanOrEqualTo(Date value) {
            addCriterion("gmt_verify_exp <=", value, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpIn(List<Date> values) {
            addCriterion("gmt_verify_exp in", values, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpNotIn(List<Date> values) {
            addCriterion("gmt_verify_exp not in", values, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpBetween(Date value1, Date value2) {
            addCriterion("gmt_verify_exp between", value1, value2, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyExpNotBetween(Date value1, Date value2) {
            addCriterion("gmt_verify_exp not between", value1, value2, "gmtVerifyExp");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasIsNull() {
            addCriterion("gmt_verify_pas is null");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasIsNotNull() {
            addCriterion("gmt_verify_pas is not null");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasEqualTo(Date value) {
            addCriterion("gmt_verify_pas =", value, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasNotEqualTo(Date value) {
            addCriterion("gmt_verify_pas <>", value, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasGreaterThan(Date value) {
            addCriterion("gmt_verify_pas >", value, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_verify_pas >=", value, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasLessThan(Date value) {
            addCriterion("gmt_verify_pas <", value, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasLessThanOrEqualTo(Date value) {
            addCriterion("gmt_verify_pas <=", value, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasIn(List<Date> values) {
            addCriterion("gmt_verify_pas in", values, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasNotIn(List<Date> values) {
            addCriterion("gmt_verify_pas not in", values, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasBetween(Date value1, Date value2) {
            addCriterion("gmt_verify_pas between", value1, value2, "gmtVerifyPas");
            return (Criteria) this;
        }

        public Criteria andGmtVerifyPasNotBetween(Date value1, Date value2) {
            addCriterion("gmt_verify_pas not between", value1, value2, "gmtVerifyPas");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eh_logon_info
     *
     * @mbggenerated do_not_delete_during_merge Thu Mar 17 10:52:23 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eh_logon_info
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}