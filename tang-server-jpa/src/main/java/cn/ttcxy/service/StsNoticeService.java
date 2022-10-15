package cn.ttcxy.service;

import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.entity.param.StsNoticeParam;
import cn.ttcxy.mapper.dsl.StsNoticeDsl;
import cn.ttcxy.mapper.repository.StsNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告
 */
@Service
public class StsNoticeService {

    @Autowired
    private StsNoticeRepository noticeRepository;

    @Autowired
    private StsNoticeDsl noticeDsl;


    
    public List<StsNotice> selectAllNotice() {

        return noticeRepository.findAllOrderByOrderNumAsc();
    }

    
    public StsNotice selectById(String id) {
        return noticeRepository.findById(id).orElseThrow();
    }

    
    public StsNotice insertNotice(StsNotice notice) {
        String id = IdUtil.objectId();
        notice.setNoticeId(id);
        Integer integer = noticeDsl.selectNoticeMaxOrder();
        notice.setOrderNum(integer+1);
        return noticeRepository.save(notice);
    }

    
    public StsNotice updateNotice(StsNotice notice) {
        return noticeRepository.save(notice);
    }

    
    public void deleteNotice(String id) {
        noticeRepository.deleteById(id);
    }


    public void updateNoticeOrder(StsNoticeParam[] noticeList) {
        for (int i = 0; i < noticeList.length; i++) {
            StsNoticeParam stsNoticeParam = noticeList[i];
            String id = stsNoticeParam.getNoticeId();
            StsNotice notice = new StsNotice();
            notice.setNoticeId(id);
            notice.setOrderNum(i);
            noticeRepository.save(notice);
        }
    }
}
