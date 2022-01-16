package net.ttcxy.tang.portal.service;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.entity.model.DtsNotice;
import net.ttcxy.tang.portal.mapper.DtsNoticeMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsNoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告
 * @author huanglei
 */
@Service
public class StsNoticeService {

    @Autowired
    private DtsNoticeMapper noticeMapper;

    @Autowired
    private DtsNoticeDao noticeDao;


    
    public List<DtsNotice> selectAllNotice() {
        return noticeDao.selectNoticeAll();
    }

    
    public DtsNotice selectById(String id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    
    public int insertNotice(DtsNotice notice) {
        String id = IdUtil.objectId();
        notice.setNoticeId(id);
        return noticeMapper.insertSelective(notice);
    }

    
    public int updateNotice(DtsNotice notice) {
        return noticeMapper.updateByPrimaryKey(notice);
    }

    
    public int deleteNotice(String id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }


}
