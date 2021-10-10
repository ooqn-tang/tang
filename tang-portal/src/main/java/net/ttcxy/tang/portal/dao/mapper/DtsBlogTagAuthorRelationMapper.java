package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsBlogTagAuthorRelation;
import net.ttcxy.tang.portal.entity.model.DtsBlogTagAuthorRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogTagAuthorRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    long countByExample(DtsBlogTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int deleteByExample(DtsBlogTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int deleteByPrimaryKey(String blogTagAuthorRelationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int insert(DtsBlogTagAuthorRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int insertSelective(DtsBlogTagAuthorRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    DtsBlogTagAuthorRelation selectByPrimaryKey(String blogTagAuthorRelationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByExampleSelective(@Param("record") DtsBlogTagAuthorRelation record, @Param("example") DtsBlogTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByExample(@Param("record") DtsBlogTagAuthorRelation record, @Param("example") DtsBlogTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByPrimaryKeySelective(DtsBlogTagAuthorRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag_author_relation
     *
     * @mbg.generated Sun Oct 10 17:08:13 CST 2021
     */
    int updateByPrimaryKey(DtsBlogTagAuthorRelation record);
}