package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsLikeBlog;
import net.ttcxy.tang.portal.entity.model.DtsLikeBlogExample;
import org.apache.ibatis.annotations.Param;

public interface DtsLikeBlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    long countByExample(DtsLikeBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int deleteByExample(DtsLikeBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int deleteByPrimaryKey(String likeBlogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int insert(DtsLikeBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int insertSelective(DtsLikeBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    DtsLikeBlog selectByPrimaryKey(String likeBlogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByExampleSelective(@Param("record") DtsLikeBlog record, @Param("example") DtsLikeBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByExample(@Param("record") DtsLikeBlog record, @Param("example") DtsLikeBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByPrimaryKeySelective(DtsLikeBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_like_blog
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByPrimaryKey(DtsLikeBlog record);
}