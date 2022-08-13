package cn.ttcxy.service;

import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.entity.model.StsNoticeExample;
import cn.ttcxy.entity.param.StsNoticeParam;
import cn.ttcxy.mapper.StsNoticeMapper;
import cn.ttcxy.mapper.dao.StsNoticeDao;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告
 */
@Service
public class StsNoticeService {

    @Autowired
    private StsNoticeMapper noticeMapper;

    @Autowired
    private StsNoticeDao noticeDao;


    
    public List<StsNotice> selectAllNotice() {
        StsNoticeExample noticeExample = new StsNoticeExample();
        noticeExample.setOrderByClause("order_num");
        return noticeMapper.selectByExample(noticeExample);
    }

    
    public StsNotice selectById(String id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    
    public int insertNotice(StsNotice notice) {
        String id = IdUtil.objectId();
        notice.setNoticeId(id);

        Integer integer = noticeDao.selectNoticeMaxOrder();
        notice.setOrderNum(integer+1);
        return noticeMapper.insertSelective(notice);
    }

    
    public int updateNotice(StsNotice notice) {
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    
    public int deleteNotice(String id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }


    public void updateNoticeOrder(StsNoticeParam[] noticeList) {
        for (int i = 0; i < noticeList.length; i++) {
            StsNoticeParam stsNoticeParam = noticeList[i];
            String id = stsNoticeParam.getNoticeId();
            StsNotice notice = new StsNotice();
            notice.setNoticeId(id);
            notice.setOrderNum(i);
            noticeMapper.updateByPrimaryKeySelective(notice);
        }
    }
}
