package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.portal.entity.model.DtsBlogTag;

import java.util.List;

public interface DtsBlogTagService {

    /**
     * 通过ID 查询标签详细消息
     * @param tagId 标签ID
     * @return 详细信息
     */
    DtsBlogTagDto selectTagInfo(String tagId);

    /**
     * 通过ID 查询标签详细消息
     * 以及标签文章列表
     * @param tagId 标签ID
     * @return 详细信息
     */
    DtsBlogTagDto selectTagBlogCountListByUsername(String tagId, String username);


    /**
     * 查询标签列表
     * @param page page
     * @param size 行
     * @return 结果
     */
    PageInfo<DtsBlogTagDto> selectTagList(Integer page , Integer size);



    /**
     * 添加标签
     * @param blogTag 标签
     * @return 结果
     */
    String insertTag(DtsBlogTag blogTag);

    /**
     * 通过Id 修改标签
     * @param blogTag 标签
     * @return 影响的行数
     */
    Integer updateTag(DtsBlogTag blogTag);


    /**
     * 模糊搜索
     * @param name name
     * @param page page
     * @param pageSize pageSize
     * @return 结果
     */
    PageInfo<DtsBlogTagDto> selectTagListByName(String name, int page, int pageSize);

    /**
     * 获取作者所有tag
     */
    List<DtsBlogTagDto> selectAuthorAllTag();

    /**
     * 添加作者的tag
     */
    Integer insertAuthorTag(String authorId, String tagId);
}
