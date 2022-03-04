package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.model.StsNotice;

import java.util.List;

public interface StsNoticeDao {
    List<StsNotice> selectNoticeAll();

    Integer selectNoticeMaxOrder();
}
