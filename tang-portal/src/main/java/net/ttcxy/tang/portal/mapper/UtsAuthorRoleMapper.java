package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.UtsAuthorRole;
import net.ttcxy.tang.portal.entity.model.UtsAuthorRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAuthorRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    long countByExample(UtsAuthorRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int deleteByExample(UtsAuthorRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int deleteByPrimaryKey(String authorRoleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int insert(UtsAuthorRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int insertSelective(UtsAuthorRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    UtsAuthorRole selectByPrimaryKey(String authorRoleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int updateByExampleSelective(@Param("record") UtsAuthorRole record, @Param("example") UtsAuthorRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int updateByExample(@Param("record") UtsAuthorRole record, @Param("example") UtsAuthorRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int updateByPrimaryKeySelective(UtsAuthorRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    int updateByPrimaryKey(UtsAuthorRole record);
}