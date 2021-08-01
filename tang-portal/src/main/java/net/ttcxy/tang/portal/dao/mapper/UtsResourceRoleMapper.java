package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.UtsResourceRole;
import net.ttcxy.tang.portal.entity.model.UtsResourceRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    long countByExample(UtsResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int deleteByExample(UtsResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int deleteByPrimaryKey(String resourceRoleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int insert(UtsResourceRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int insertSelective(UtsResourceRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    UtsResourceRole selectByPrimaryKey(String resourceRoleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByExampleSelective(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByExample(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByPrimaryKeySelective(UtsResourceRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByPrimaryKey(UtsResourceRole record);
}