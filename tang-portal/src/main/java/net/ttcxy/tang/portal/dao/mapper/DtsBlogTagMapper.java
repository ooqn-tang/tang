package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsBlogTag;
import net.ttcxy.tang.portal.entity.model.DtsBlogTagExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    long countByExample(DtsBlogTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int deleteByExample(DtsBlogTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int deleteByPrimaryKey(String blogTagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int insert(DtsBlogTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int insertSelective(DtsBlogTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    DtsBlogTag selectByPrimaryKey(String blogTagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByExampleSelective(@Param("record") DtsBlogTag record, @Param("example") DtsBlogTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByExample(@Param("record") DtsBlogTag record, @Param("example") DtsBlogTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByPrimaryKeySelective(DtsBlogTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_tag
     *
     * @mbg.generated Fri Aug 20 19:50:04 CST 2021
     */
    int updateByPrimaryKey(DtsBlogTag record);
}