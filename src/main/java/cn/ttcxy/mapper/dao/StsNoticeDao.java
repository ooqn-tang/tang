package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.model.StsNotice;

import java.util.List;

public interface StsNoticeDao {

    List<StsNotice> selectNoticeAll();

    Integer selectNoticeMaxOrder();

}
