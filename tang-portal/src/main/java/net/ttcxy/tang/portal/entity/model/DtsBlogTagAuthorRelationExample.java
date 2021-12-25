package net.ttcxy.tang.portal.entity.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtsBlogTagAuthorRelationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public DtsBlogTagAuthorRelationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
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
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
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

        public Criteria andBlogTagAuthorRelationIdIsNull() {
            addCriterion("blog_tag_author_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdIsNotNull() {
            addCriterion("blog_tag_author_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdEqualTo(String value) {
            addCriterion("blog_tag_author_relation_id =", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdNotEqualTo(String value) {
            addCriterion("blog_tag_author_relation_id <>", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdGreaterThan(String value) {
            addCriterion("blog_tag_author_relation_id >", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("blog_tag_author_relation_id >=", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdLessThan(String value) {
            addCriterion("blog_tag_author_relation_id <", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdLessThanOrEqualTo(String value) {
            addCriterion("blog_tag_author_relation_id <=", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdLike(String value) {
            addCriterion("blog_tag_author_relation_id like", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdNotLike(String value) {
            addCriterion("blog_tag_author_relation_id not like", value, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdIn(List<String> values) {
            addCriterion("blog_tag_author_relation_id in", values, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdNotIn(List<String> values) {
            addCriterion("blog_tag_author_relation_id not in", values, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdBetween(String value1, String value2) {
            addCriterion("blog_tag_author_relation_id between", value1, value2, "blogTagAuthorRelationId");
            return (Criteria) this;
        }

        public Criteria andBlogTagAuthorRelationIdNotBetween(String value1, String value2) {
            addCriterion("blog_tag_author_relation_id not between", value1, value2, "blogTagAuthorRelationId");
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

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated do_not_delete_during_merge Sat Dec 25 13:36:32 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
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