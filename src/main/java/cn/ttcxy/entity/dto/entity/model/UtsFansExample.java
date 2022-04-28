package cn.ttcxy.entity.dto.entity.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtsFansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UtsFansExample() {
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

        public Criteria andFansIdIsNull() {
            addCriterion("fans_id is null");
            return (Criteria) this;
        }

        public Criteria andFansIdIsNotNull() {
            addCriterion("fans_id is not null");
            return (Criteria) this;
        }

        public Criteria andFansIdEqualTo(String value) {
            addCriterion("fans_id =", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotEqualTo(String value) {
            addCriterion("fans_id <>", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdGreaterThan(String value) {
            addCriterion("fans_id >", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdGreaterThanOrEqualTo(String value) {
            addCriterion("fans_id >=", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdLessThan(String value) {
            addCriterion("fans_id <", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdLessThanOrEqualTo(String value) {
            addCriterion("fans_id <=", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdLike(String value) {
            addCriterion("fans_id like", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotLike(String value) {
            addCriterion("fans_id not like", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdIn(List<String> values) {
            addCriterion("fans_id in", values, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotIn(List<String> values) {
            addCriterion("fans_id not in", values, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdBetween(String value1, String value2) {
            addCriterion("fans_id between", value1, value2, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotBetween(String value1, String value2) {
            addCriterion("fans_id not between", value1, value2, "fansId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdIsNull() {
            addCriterion("be_author_id is null");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdIsNotNull() {
            addCriterion("be_author_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdEqualTo(String value) {
            addCriterion("be_author_id =", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdNotEqualTo(String value) {
            addCriterion("be_author_id <>", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdGreaterThan(String value) {
            addCriterion("be_author_id >", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdGreaterThanOrEqualTo(String value) {
            addCriterion("be_author_id >=", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdLessThan(String value) {
            addCriterion("be_author_id <", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdLessThanOrEqualTo(String value) {
            addCriterion("be_author_id <=", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdLike(String value) {
            addCriterion("be_author_id like", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdNotLike(String value) {
            addCriterion("be_author_id not like", value, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdIn(List<String> values) {
            addCriterion("be_author_id in", values, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdNotIn(List<String> values) {
            addCriterion("be_author_id not in", values, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdBetween(String value1, String value2) {
            addCriterion("be_author_id between", value1, value2, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andBeAuthorIdNotBetween(String value1, String value2) {
            addCriterion("be_author_id not between", value1, value2, "beAuthorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(String value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(String value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(String value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(String value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(String value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(String value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLike(String value) {
            addCriterion("author_id like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotLike(String value) {
            addCriterion("author_id not like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<String> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<String> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(String value1, String value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(String value1, String value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
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