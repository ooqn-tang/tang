package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.model.StsNotice;

import java.util.List;

/**
 * 推荐
 */
public interface StsNoticeDao {

    List<StsNotice> selectNoticeAll();

    Integer selectNoticeMaxOrder();

}
