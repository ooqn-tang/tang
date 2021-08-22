package net.ttcxy.tang.portal.service;


import net.ttcxy.tang.portal.entity.model.DtsNotice;

import java.util.List;

/**
 * 广告服务
 * @author huanglei
 */
public interface StsNoticeService {

    /**
     * 查询全部广告
     * @return 所有广告的集合
     */
    List<DtsNotice> selectAllNotice();

    /**
     * 根据广告id查询
     * @param id 要查询的广告id
     * @return 根据id查询的广告信息
     */
    DtsNotice selectById(String id);

    /**
     * 向数据库插入一条广告信息
     * @param notice 封装的广告信息
     * @return
     */
    int insertNotice(DtsNotice notice);

    /**
     * 更新一条广告信息
     * @param notice 封装的广告信息
     * @return
     */
    int updateNotice(DtsNotice notice);

    /**
     * 删除一条广告信息
     * @param id 要删除的广告id
     * @return
     */
    int deleteNotice(String id);

}
