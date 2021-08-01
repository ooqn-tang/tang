package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsBlog;
import net.ttcxy.tang.portal.entity.model.DtsBlogExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    long countByExample(DtsBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int deleteByExample(DtsBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int deleteByPrimaryKey(String blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int insert(DtsBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int insertSelective(DtsBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    DtsBlog selectByPrimaryKey(String blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByExampleSelective(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByExample(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByPrimaryKeySelective(DtsBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(DtsBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByPrimaryKey(DtsBlog record);
}