package net.ttcxy.tang.portal.dao;

import net.ttcxy.tang.portal.entity.model.DtsNotice;

import java.util.List;

public interface DtsNoticeDao {
    List<DtsNotice> selectNoticeAll();
}
