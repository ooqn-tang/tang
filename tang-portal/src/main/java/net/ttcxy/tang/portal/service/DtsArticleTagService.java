package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsArticleTagDto;
import net.ttcxy.tang.portal.entity.model.DtsArticleTag;

import java.util.List;

public interface DtsArticleTagService {

    /**
     * 通过ID 查询标签详细消息
     * @param tagId 标签ID
     * @return 详细信息
     */
    DtsArticleTagDto selectTagInfo(String tagId);

    /**
     * 通过ID 查询标签详细消息
     * 以及标签文章列表
     * @param tagId 标签ID
     * @return 详细信息
     */
    DtsArticleTagDto selectTagArticleCountListByUsername(String tagId, String username);


    /**
     * 查询标签列表
     * @param page page
     * @param size 行
     * @return 结果
     */
    PageInfo<DtsArticleTagDto> selectTagList(Integer page , Integer size);



    /**
     * 添加标签
     * @param articleTag 标签
     * @return 结果
     */
    String insertTag(DtsArticleTag articleTag);

    /**
     * 通过Id 修改标签
     * @param articleTag 标签
     * @return 影响的行数
     */
    Integer updateTag(DtsArticleTag articleTag);


    /**
     * 模糊搜索
     * @param name name
     * @param page page
     * @param pageSize pageSize
     * @return 结果
     */
    PageInfo<DtsArticleTagDto> selectTagListByName(String name, int page, int pageSize);

    /**
     * 获取作者所有tag
     */
    List<DtsArticleTagDto> selectAuthorAllTag();

    /**
     * 添加作者的tag
     */
    Integer insertAuthorTag(String authorId, String tagId);
}
