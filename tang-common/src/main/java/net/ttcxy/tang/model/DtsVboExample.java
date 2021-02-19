package net.ttcxy.tang.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtsVboExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DtsVboExample() {
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

        public Criteria andUtsAuthorUuidIsNull() {
            addCriterion("uts_author_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidIsNotNull() {
            addCriterion("uts_author_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidEqualTo(String value) {
            addCriterion("uts_author_uuid =", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidNotEqualTo(String value) {
            addCriterion("uts_author_uuid <>", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidGreaterThan(String value) {
            addCriterion("uts_author_uuid >", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uts_author_uuid >=", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidLessThan(String value) {
            addCriterion("uts_author_uuid <", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidLessThanOrEqualTo(String value) {
            addCriterion("uts_author_uuid <=", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidLike(String value) {
            addCriterion("uts_author_uuid like", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidNotLike(String value) {
            addCriterion("uts_author_uuid not like", value, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidIn(List<String> values) {
            addCriterion("uts_author_uuid in", values, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidNotIn(List<String> values) {
            addCriterion("uts_author_uuid not in", values, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidBetween(String value1, String value2) {
            addCriterion("uts_author_uuid between", value1, value2, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andUtsAuthorUuidNotBetween(String value1, String value2) {
            addCriterion("uts_author_uuid not between", value1, value2, "utsAuthorUuid");
            return (Criteria) this;
        }

        public Criteria andVboTextIsNull() {
            addCriterion("vbo_text is null");
            return (Criteria) this;
        }

        public Criteria andVboTextIsNotNull() {
            addCriterion("vbo_text is not null");
            return (Criteria) this;
        }

        public Criteria andVboTextEqualTo(String value) {
            addCriterion("vbo_text =", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextNotEqualTo(String value) {
            addCriterion("vbo_text <>", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextGreaterThan(String value) {
            addCriterion("vbo_text >", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextGreaterThanOrEqualTo(String value) {
            addCriterion("vbo_text >=", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextLessThan(String value) {
            addCriterion("vbo_text <", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextLessThanOrEqualTo(String value) {
            addCriterion("vbo_text <=", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextLike(String value) {
            addCriterion("vbo_text like", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextNotLike(String value) {
            addCriterion("vbo_text not like", value, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextIn(List<String> values) {
            addCriterion("vbo_text in", values, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextNotIn(List<String> values) {
            addCriterion("vbo_text not in", values, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextBetween(String value1, String value2) {
            addCriterion("vbo_text between", value1, value2, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboTextNotBetween(String value1, String value2) {
            addCriterion("vbo_text not between", value1, value2, "vboText");
            return (Criteria) this;
        }

        public Criteria andVboUrlIsNull() {
            addCriterion("vbo_url is null");
            return (Criteria) this;
        }

        public Criteria andVboUrlIsNotNull() {
            addCriterion("vbo_url is not null");
            return (Criteria) this;
        }

        public Criteria andVboUrlEqualTo(String value) {
            addCriterion("vbo_url =", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlNotEqualTo(String value) {
            addCriterion("vbo_url <>", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlGreaterThan(String value) {
            addCriterion("vbo_url >", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlGreaterThanOrEqualTo(String value) {
            addCriterion("vbo_url >=", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlLessThan(String value) {
            addCriterion("vbo_url <", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlLessThanOrEqualTo(String value) {
            addCriterion("vbo_url <=", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlLike(String value) {
            addCriterion("vbo_url like", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlNotLike(String value) {
            addCriterion("vbo_url not like", value, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlIn(List<String> values) {
            addCriterion("vbo_url in", values, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlNotIn(List<String> values) {
            addCriterion("vbo_url not in", values, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlBetween(String value1, String value2) {
            addCriterion("vbo_url between", value1, value2, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlNotBetween(String value1, String value2) {
            addCriterion("vbo_url not between", value1, value2, "vboUrl");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameIsNull() {
            addCriterion("vbo_url_name is null");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameIsNotNull() {
            addCriterion("vbo_url_name is not null");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameEqualTo(String value) {
            addCriterion("vbo_url_name =", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameNotEqualTo(String value) {
            addCriterion("vbo_url_name <>", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameGreaterThan(String value) {
            addCriterion("vbo_url_name >", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameGreaterThanOrEqualTo(String value) {
            addCriterion("vbo_url_name >=", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameLessThan(String value) {
            addCriterion("vbo_url_name <", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameLessThanOrEqualTo(String value) {
            addCriterion("vbo_url_name <=", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameLike(String value) {
            addCriterion("vbo_url_name like", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameNotLike(String value) {
            addCriterion("vbo_url_name not like", value, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameIn(List<String> values) {
            addCriterion("vbo_url_name in", values, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameNotIn(List<String> values) {
            addCriterion("vbo_url_name not in", values, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameBetween(String value1, String value2) {
            addCriterion("vbo_url_name between", value1, value2, "vboUrlName");
            return (Criteria) this;
        }

        public Criteria andVboUrlNameNotBetween(String value1, String value2) {
            addCriterion("vbo_url_name not between", value1, value2, "vboUrlName");
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

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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