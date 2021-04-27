package net.ttcxy.tang.gateway.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogSubjectDto;

public interface DtsBlogSubjectService {

    /**
     * 通过ID 查询专题详细消息
     * @param subjectId 专题ID
     * @return 详细信息
     */
    DtsBlogSubjectDto selectSubjectInfo(String subjectId);

    /**
     * 通过ID 查询专题详细消息 以及专题文章列表
     * @param subjectId 专题ID
     * @return 详细信息
     */
    DtsBlogSubjectDto selectSubjectAllInfo(String subjectId);

    /**
     * 查询专题列表
     * @param page page
     * @param size 行
     * @param name 名字
     * @return 结果
     */
    PageInfo<DtsBlogSubjectDto> selectSubjectList(Integer page , Integer size, String name);



    /**
     * 添加专题
     * @param subjectDto 专题
     * @return 结果
     */
    Integer insertSubject(DtsBlogSubjectDto subjectDto);

    /**
     * 通过Id 删除专题
     * @param subjectId id
     * @return 影响的行数
     */
    Integer deleteSubject(String subjectId);

    /**
     * 通过Id 修改专题
     * @param subjectDto 专题
     * @return 影响的行数
     */
    Integer updateSubject(DtsBlogSubjectDto subjectDto);


}
