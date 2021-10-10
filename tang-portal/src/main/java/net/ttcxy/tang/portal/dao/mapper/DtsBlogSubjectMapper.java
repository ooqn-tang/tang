package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsBlogSubject;
import net.ttcxy.tang.portal.entity.model.DtsBlogSubjectExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogSubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    long countByExample(DtsBlogSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int deleteByExample(DtsBlogSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int deleteByPrimaryKey(String blogSubjectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int insert(DtsBlogSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int insertSelective(DtsBlogSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    DtsBlogSubject selectByPrimaryKey(String blogSubjectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByExampleSelective(@Param("record") DtsBlogSubject record, @Param("example") DtsBlogSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByExample(@Param("record") DtsBlogSubject record, @Param("example") DtsBlogSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByPrimaryKeySelective(DtsBlogSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByPrimaryKey(DtsBlogSubject record);
}