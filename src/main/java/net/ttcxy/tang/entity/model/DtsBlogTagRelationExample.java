package net.ttcxy.tang.entity.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtsBlogTagRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DtsBlogTagRelationExample() {
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

        public Criteria andBlogTagRelationIdIsNull() {
            addCriterion("blog_tag_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdIsNotNull() {
            addCriterion("blog_tag_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdEqualTo(String value) {
            addCriterion("blog_tag_relation_id =", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdNotEqualTo(String value) {
            addCriterion("blog_tag_relation_id <>", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdGreaterThan(String value) {
            addCriterion("blog_tag_relation_id >", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("blog_tag_relation_id >=", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdLessThan(String value) {
            addCriterion("blog_tag_relation_id <", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdLessThanOrEqualTo(String value) {
            addCriterion("blog_tag_relation_id <=", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdLike(String value) {
            addCriterion("blog_tag_relation_id like", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdNotLike(String value) {
            addCriterion("blog_tag_relation_id not like", value, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdIn(List<String> values) {
            addCriterion("blog_tag_relation_id in", values, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdNotIn(List<String> values) {
            addCriterion("blog_tag_relation_id not in", values, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdBetween(String value1, String value2) {
            addCriterion("blog_tag_relation_id between", value1, value2, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagRelationIdNotBetween(String value1, String value2) {
            addCriterion("blog_tag_relation_id not between", value1, value2, "blogTagRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(String value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(String value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(String value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(String value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(String value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(String value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLike(String value) {
            addCriterion("blog_id like", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotLike(String value) {
            addCriterion("blog_id not like", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<String> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<String> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(String value1, String value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(String value1, String value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdIsNull() {
            addCriterion("blog_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdIsNotNull() {
            addCriterion("blog_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdEqualTo(String value) {
            addCriterion("blog_tag_id =", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdNotEqualTo(String value) {
            addCriterion("blog_tag_id <>", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdGreaterThan(String value) {
            addCriterion("blog_tag_id >", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdGreaterThanOrEqualTo(String value) {
            addCriterion("blog_tag_id >=", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdLessThan(String value) {
            addCriterion("blog_tag_id <", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdLessThanOrEqualTo(String value) {
            addCriterion("blog_tag_id <=", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdLike(String value) {
            addCriterion("blog_tag_id like", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdNotLike(String value) {
            addCriterion("blog_tag_id not like", value, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdIn(List<String> values) {
            addCriterion("blog_tag_id in", values, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdNotIn(List<String> values) {
            addCriterion("blog_tag_id not in", values, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdBetween(String value1, String value2) {
            addCriterion("blog_tag_id between", value1, value2, "blogTagId");
            return (Criteria) this;
        }

        public Criteria andBlogTagIdNotBetween(String value1, String value2) {
            addCriterion("blog_tag_id not between", value1, value2, "blogTagId");
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