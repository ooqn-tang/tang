package net.ttcxy.tang.gateway.entity.model;

import java.util.ArrayList;
import java.util.List;

public class UtsFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UtsFileExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("FILE_ID =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("FILE_ID <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("FILE_ID >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FILE_ID >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("FILE_ID <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("FILE_ID <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("FILE_ID in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("FILE_ID not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("FILE_ID between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FILE_ID not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("FILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("FILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("FILE_TYPE =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("FILE_TYPE <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("FILE_TYPE >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("FILE_TYPE <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("FILE_TYPE like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("FILE_TYPE not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("FILE_TYPE in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("FILE_TYPE not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("FILE_TYPE between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("FILE_TYPE not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FILE_PATH =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FILE_PATH <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FILE_PATH >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_PATH >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("FILE_PATH <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FILE_PATH <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("FILE_PATH like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("FILE_PATH not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FILE_PATH in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FILE_PATH not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FILE_PATH between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FILE_PATH not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileDateIsNull() {
            addCriterion("FILE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andFileDateIsNotNull() {
            addCriterion("FILE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andFileDateEqualTo(String value) {
            addCriterion("FILE_DATE =", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotEqualTo(String value) {
            addCriterion("FILE_DATE <>", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateGreaterThan(String value) {
            addCriterion("FILE_DATE >", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_DATE >=", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateLessThan(String value) {
            addCriterion("FILE_DATE <", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateLessThanOrEqualTo(String value) {
            addCriterion("FILE_DATE <=", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateLike(String value) {
            addCriterion("FILE_DATE like", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotLike(String value) {
            addCriterion("FILE_DATE not like", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateIn(List<String> values) {
            addCriterion("FILE_DATE in", values, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotIn(List<String> values) {
            addCriterion("FILE_DATE not in", values, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateBetween(String value1, String value2) {
            addCriterion("FILE_DATE between", value1, value2, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotBetween(String value1, String value2) {
            addCriterion("FILE_DATE not between", value1, value2, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileIcoIsNull() {
            addCriterion("FILE_ICO is null");
            return (Criteria) this;
        }

        public Criteria andFileIcoIsNotNull() {
            addCriterion("FILE_ICO is not null");
            return (Criteria) this;
        }

        public Criteria andFileIcoEqualTo(String value) {
            addCriterion("FILE_ICO =", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoNotEqualTo(String value) {
            addCriterion("FILE_ICO <>", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoGreaterThan(String value) {
            addCriterion("FILE_ICO >", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_ICO >=", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoLessThan(String value) {
            addCriterion("FILE_ICO <", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoLessThanOrEqualTo(String value) {
            addCriterion("FILE_ICO <=", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoLike(String value) {
            addCriterion("FILE_ICO like", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoNotLike(String value) {
            addCriterion("FILE_ICO not like", value, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoIn(List<String> values) {
            addCriterion("FILE_ICO in", values, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoNotIn(List<String> values) {
            addCriterion("FILE_ICO not in", values, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoBetween(String value1, String value2) {
            addCriterion("FILE_ICO between", value1, value2, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileIcoNotBetween(String value1, String value2) {
            addCriterion("FILE_ICO not between", value1, value2, "fileIco");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("FILE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("FILE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(String value) {
            addCriterion("FILE_SIZE =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(String value) {
            addCriterion("FILE_SIZE <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(String value) {
            addCriterion("FILE_SIZE >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_SIZE >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(String value) {
            addCriterion("FILE_SIZE <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(String value) {
            addCriterion("FILE_SIZE <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLike(String value) {
            addCriterion("FILE_SIZE like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotLike(String value) {
            addCriterion("FILE_SIZE not like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<String> values) {
            addCriterion("FILE_SIZE in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<String> values) {
            addCriterion("FILE_SIZE not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(String value1, String value2) {
            addCriterion("FILE_SIZE between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(String value1, String value2) {
            addCriterion("FILE_SIZE not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileParentIdIsNull() {
            addCriterion("FILE_PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileParentIdIsNotNull() {
            addCriterion("FILE_PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileParentIdEqualTo(Integer value) {
            addCriterion("FILE_PARENT_ID =", value, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdNotEqualTo(Integer value) {
            addCriterion("FILE_PARENT_ID <>", value, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdGreaterThan(Integer value) {
            addCriterion("FILE_PARENT_ID >", value, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FILE_PARENT_ID >=", value, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdLessThan(Integer value) {
            addCriterion("FILE_PARENT_ID <", value, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("FILE_PARENT_ID <=", value, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdIn(List<Integer> values) {
            addCriterion("FILE_PARENT_ID in", values, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdNotIn(List<Integer> values) {
            addCriterion("FILE_PARENT_ID not in", values, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdBetween(Integer value1, Integer value2) {
            addCriterion("FILE_PARENT_ID between", value1, value2, "fileParentId");
            return (Criteria) this;
        }

        public Criteria andFileParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FILE_PARENT_ID not between", value1, value2, "fileParentId");
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