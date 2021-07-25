package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.UtsRole;
import net.ttcxy.tang.portal.entity.model.UtsRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    long countByExample(UtsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int deleteByExample(UtsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int insert(UtsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int insertSelective(UtsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    UtsRole selectByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByExampleSelective(@Param("record") UtsRole record, @Param("example") UtsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByExample(@Param("record") UtsRole record, @Param("example") UtsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByPrimaryKeySelective(UtsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    int updateByPrimaryKey(UtsRole record);
}