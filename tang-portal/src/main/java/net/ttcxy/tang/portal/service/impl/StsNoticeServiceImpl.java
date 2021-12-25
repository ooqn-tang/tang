package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.entity.model.DtsNotice;
import net.ttcxy.tang.portal.mapper.DtsNoticeMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsNoticeDao;
import net.ttcxy.tang.portal.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告
 * @author huanglei
 */
@Service
public class StsNoticeServiceImpl implements StsNoticeService {

    @Autowired
    private DtsNoticeMapper noticeMapper;

    @Autowired
    private DtsNoticeDao noticeDao;


    @Override
    public List<DtsNotice> selectAllNotice() {
        return noticeDao.selectNoticeAll();
    }

    @Override
    public DtsNotice selectById(String id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertNotice(DtsNotice notice) {
        String id = IdUtil.objectId();
        notice.setNoticeId(id);
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public int updateNotice(DtsNotice notice) {
        return noticeMapper.updateByPrimaryKey(notice);
    }

    @Override
    public int deleteNotice(String id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }


}
