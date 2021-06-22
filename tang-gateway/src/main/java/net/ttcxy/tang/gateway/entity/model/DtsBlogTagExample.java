package net.ttcxy.tang.gateway.entity.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtsBlogTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DtsBlogTagExample() {
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

        public Criteria andTagNameIsNull() {
            addCriterion("tag_name is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("tag_name =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("tag_name <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("tag_name >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_name >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("tag_name <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("tag_name <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("tag_name like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("tag_name not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("tag_name in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("tag_name not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("tag_name between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("tag_name not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andSynopsisIsNull() {
            addCriterion("synopsis is null");
            return (Criteria) this;
        }

        public Criteria andSynopsisIsNotNull() {
            addCriterion("synopsis is not null");
            return (Criteria) this;
        }

        public Criteria andSynopsisEqualTo(String value) {
            addCriterion("synopsis =", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotEqualTo(String value) {
            addCriterion("synopsis <>", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisGreaterThan(String value) {
            addCriterion("synopsis >", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisGreaterThanOrEqualTo(String value) {
            addCriterion("synopsis >=", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisLessThan(String value) {
            addCriterion("synopsis <", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisLessThanOrEqualTo(String value) {
            addCriterion("synopsis <=", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisLike(String value) {
            addCriterion("synopsis like", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotLike(String value) {
            addCriterion("synopsis not like", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisIn(List<String> values) {
            addCriterion("synopsis in", values, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotIn(List<String> values) {
            addCriterion("synopsis not in", values, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisBetween(String value1, String value2) {
            addCriterion("synopsis between", value1, value2, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotBetween(String value1, String value2) {
            addCriterion("synopsis not between", value1, value2, "synopsis");
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