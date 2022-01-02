package net.ttcxy.tang.portal.entity.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtsArticleSubjectRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DtsArticleSubjectRelationExample() {
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

        public Criteria andArticleSubjectRelationIdIsNull() {
            addCriterion("article_subject_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdIsNotNull() {
            addCriterion("article_subject_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdEqualTo(String value) {
            addCriterion("article_subject_relation_id =", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdNotEqualTo(String value) {
            addCriterion("article_subject_relation_id <>", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdGreaterThan(String value) {
            addCriterion("article_subject_relation_id >", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_subject_relation_id >=", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdLessThan(String value) {
            addCriterion("article_subject_relation_id <", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdLessThanOrEqualTo(String value) {
            addCriterion("article_subject_relation_id <=", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdLike(String value) {
            addCriterion("article_subject_relation_id like", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdNotLike(String value) {
            addCriterion("article_subject_relation_id not like", value, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdIn(List<String> values) {
            addCriterion("article_subject_relation_id in", values, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdNotIn(List<String> values) {
            addCriterion("article_subject_relation_id not in", values, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdBetween(String value1, String value2) {
            addCriterion("article_subject_relation_id between", value1, value2, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectRelationIdNotBetween(String value1, String value2) {
            addCriterion("article_subject_relation_id not between", value1, value2, "articleSubjectRelationId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdIsNull() {
            addCriterion("article_subject_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdIsNotNull() {
            addCriterion("article_subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdEqualTo(String value) {
            addCriterion("article_subject_id =", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdNotEqualTo(String value) {
            addCriterion("article_subject_id <>", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdGreaterThan(String value) {
            addCriterion("article_subject_id >", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_subject_id >=", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdLessThan(String value) {
            addCriterion("article_subject_id <", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdLessThanOrEqualTo(String value) {
            addCriterion("article_subject_id <=", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdLike(String value) {
            addCriterion("article_subject_id like", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdNotLike(String value) {
            addCriterion("article_subject_id not like", value, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdIn(List<String> values) {
            addCriterion("article_subject_id in", values, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdNotIn(List<String> values) {
            addCriterion("article_subject_id not in", values, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdBetween(String value1, String value2) {
            addCriterion("article_subject_id between", value1, value2, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleSubjectIdNotBetween(String value1, String value2) {
            addCriterion("article_subject_id not between", value1, value2, "articleSubjectId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(String value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(String value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(String value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(String value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(String value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLike(String value) {
            addCriterion("article_id like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotLike(String value) {
            addCriterion("article_id not like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<String> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<String> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(String value1, String value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(String value1, String value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
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