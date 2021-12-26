package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.DtsArticleTagAuthorRelation;
import net.ttcxy.tang.portal.entity.model.DtsArticleTagAuthorRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleTagAuthorRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    long countByExample(DtsArticleTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int deleteByExample(DtsArticleTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int deleteByPrimaryKey(String articleTagAuthorRelationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int insert(DtsArticleTagAuthorRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int insertSelective(DtsArticleTagAuthorRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    DtsArticleTagAuthorRelation selectByPrimaryKey(String articleTagAuthorRelationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int updateByExampleSelective(@Param("record") DtsArticleTagAuthorRelation record, @Param("example") DtsArticleTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int updateByExample(@Param("record") DtsArticleTagAuthorRelation record, @Param("example") DtsArticleTagAuthorRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int updateByPrimaryKeySelective(DtsArticleTagAuthorRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    int updateByPrimaryKey(DtsArticleTagAuthorRelation record);
}