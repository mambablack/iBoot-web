package com.ai.model;

import java.util.ArrayList;
import java.util.List;

public class SysParamDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysParamDetailExample() {
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

        public Criteria andPKeyIsNull() {
            addCriterion("P_KEY is null");
            return (Criteria) this;
        }

        public Criteria andPKeyIsNotNull() {
            addCriterion("P_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andPKeyEqualTo(String value) {
            addCriterion("P_KEY =", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotEqualTo(String value) {
            addCriterion("P_KEY <>", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyGreaterThan(String value) {
            addCriterion("P_KEY >", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyGreaterThanOrEqualTo(String value) {
            addCriterion("P_KEY >=", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyLessThan(String value) {
            addCriterion("P_KEY <", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyLessThanOrEqualTo(String value) {
            addCriterion("P_KEY <=", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyLike(String value) {
            addCriterion("P_KEY like", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotLike(String value) {
            addCriterion("P_KEY not like", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyIn(List<String> values) {
            addCriterion("P_KEY in", values, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotIn(List<String> values) {
            addCriterion("P_KEY not in", values, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyBetween(String value1, String value2) {
            addCriterion("P_KEY between", value1, value2, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotBetween(String value1, String value2) {
            addCriterion("P_KEY not between", value1, value2, "pKey");
            return (Criteria) this;
        }

        public Criteria andPValueIsNull() {
            addCriterion("P_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andPValueIsNotNull() {
            addCriterion("P_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andPValueEqualTo(String value) {
            addCriterion("P_VALUE =", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotEqualTo(String value) {
            addCriterion("P_VALUE <>", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueGreaterThan(String value) {
            addCriterion("P_VALUE >", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueGreaterThanOrEqualTo(String value) {
            addCriterion("P_VALUE >=", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueLessThan(String value) {
            addCriterion("P_VALUE <", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueLessThanOrEqualTo(String value) {
            addCriterion("P_VALUE <=", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueLike(String value) {
            addCriterion("P_VALUE like", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotLike(String value) {
            addCriterion("P_VALUE not like", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueIn(List<String> values) {
            addCriterion("P_VALUE in", values, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotIn(List<String> values) {
            addCriterion("P_VALUE not in", values, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueBetween(String value1, String value2) {
            addCriterion("P_VALUE between", value1, value2, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotBetween(String value1, String value2) {
            addCriterion("P_VALUE not between", value1, value2, "pValue");
            return (Criteria) this;
        }

        public Criteria andPDescIsNull() {
            addCriterion("P_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPDescIsNotNull() {
            addCriterion("P_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPDescEqualTo(String value) {
            addCriterion("P_DESC =", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotEqualTo(String value) {
            addCriterion("P_DESC <>", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThan(String value) {
            addCriterion("P_DESC >", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThanOrEqualTo(String value) {
            addCriterion("P_DESC >=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThan(String value) {
            addCriterion("P_DESC <", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThanOrEqualTo(String value) {
            addCriterion("P_DESC <=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLike(String value) {
            addCriterion("P_DESC like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotLike(String value) {
            addCriterion("P_DESC not like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescIn(List<String> values) {
            addCriterion("P_DESC in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotIn(List<String> values) {
            addCriterion("P_DESC not in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescBetween(String value1, String value2) {
            addCriterion("P_DESC between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotBetween(String value1, String value2) {
            addCriterion("P_DESC not between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPPValueIsNull() {
            addCriterion("P_P_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andPPValueIsNotNull() {
            addCriterion("P_P_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andPPValueEqualTo(String value) {
            addCriterion("P_P_VALUE =", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueNotEqualTo(String value) {
            addCriterion("P_P_VALUE <>", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueGreaterThan(String value) {
            addCriterion("P_P_VALUE >", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueGreaterThanOrEqualTo(String value) {
            addCriterion("P_P_VALUE >=", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueLessThan(String value) {
            addCriterion("P_P_VALUE <", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueLessThanOrEqualTo(String value) {
            addCriterion("P_P_VALUE <=", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueLike(String value) {
            addCriterion("P_P_VALUE like", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueNotLike(String value) {
            addCriterion("P_P_VALUE not like", value, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueIn(List<String> values) {
            addCriterion("P_P_VALUE in", values, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueNotIn(List<String> values) {
            addCriterion("P_P_VALUE not in", values, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueBetween(String value1, String value2) {
            addCriterion("P_P_VALUE between", value1, value2, "pPValue");
            return (Criteria) this;
        }

        public Criteria andPPValueNotBetween(String value1, String value2) {
            addCriterion("P_P_VALUE not between", value1, value2, "pPValue");
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