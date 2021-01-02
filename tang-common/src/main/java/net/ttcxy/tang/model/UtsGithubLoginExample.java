package net.ttcxy.tang.model;

import java.util.ArrayList;
import java.util.List;

public class UtsGithubLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UtsGithubLoginExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
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

        public Criteria andGithubIdIsNull() {
            addCriterion("github_id is null");
            return (Criteria) this;
        }

        public Criteria andGithubIdIsNotNull() {
            addCriterion("github_id is not null");
            return (Criteria) this;
        }

        public Criteria andGithubIdEqualTo(String value) {
            addCriterion("github_id =", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdNotEqualTo(String value) {
            addCriterion("github_id <>", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdGreaterThan(String value) {
            addCriterion("github_id >", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdGreaterThanOrEqualTo(String value) {
            addCriterion("github_id >=", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdLessThan(String value) {
            addCriterion("github_id <", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdLessThanOrEqualTo(String value) {
            addCriterion("github_id <=", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdLike(String value) {
            addCriterion("github_id like", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdNotLike(String value) {
            addCriterion("github_id not like", value, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdIn(List<String> values) {
            addCriterion("github_id in", values, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdNotIn(List<String> values) {
            addCriterion("github_id not in", values, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdBetween(String value1, String value2) {
            addCriterion("github_id between", value1, value2, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubIdNotBetween(String value1, String value2) {
            addCriterion("github_id not between", value1, value2, "githubId");
            return (Criteria) this;
        }

        public Criteria andGithubUrlIsNull() {
            addCriterion("github_url is null");
            return (Criteria) this;
        }

        public Criteria andGithubUrlIsNotNull() {
            addCriterion("github_url is not null");
            return (Criteria) this;
        }

        public Criteria andGithubUrlEqualTo(String value) {
            addCriterion("github_url =", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlNotEqualTo(String value) {
            addCriterion("github_url <>", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlGreaterThan(String value) {
            addCriterion("github_url >", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlGreaterThanOrEqualTo(String value) {
            addCriterion("github_url >=", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlLessThan(String value) {
            addCriterion("github_url <", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlLessThanOrEqualTo(String value) {
            addCriterion("github_url <=", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlLike(String value) {
            addCriterion("github_url like", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlNotLike(String value) {
            addCriterion("github_url not like", value, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlIn(List<String> values) {
            addCriterion("github_url in", values, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlNotIn(List<String> values) {
            addCriterion("github_url not in", values, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlBetween(String value1, String value2) {
            addCriterion("github_url between", value1, value2, "githubUrl");
            return (Criteria) this;
        }

        public Criteria andGithubUrlNotBetween(String value1, String value2) {
            addCriterion("github_url not between", value1, value2, "githubUrl");
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