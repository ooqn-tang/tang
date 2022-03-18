package cn.ttcxy.service;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.mapper.StsNoticeMapper;
import cn.ttcxy.mapper.dao.StsNoticeDao;
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
        return noticeDao.selectNoticeAll();
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


    public void updateNoticeOrder(JSONArray noticeList) {
        for (int i = 0; i < noticeList.size(); i++) {
            JSONObject jsonObject = noticeList.getJSONObject(i);
            String id = jsonObject.getString("noticeId");
            StsNotice notice = new StsNotice();
            notice.setNoticeId(id);
            notice.setOrderNum(i);
            noticeMapper.updateByPrimaryKeySelective(notice);
        }
    }
}
