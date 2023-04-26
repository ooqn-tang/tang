package com.ooqn.service;

import java.util.List;

import com.ooqn.entity.model.StsNotice;
import com.ooqn.entity.param.StsNoticeParam;
import com.ooqn.repository.StsNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.IdUtil;

/**
 * 广告
 */
@Service
public class StsNoticeService {

	@Autowired
	private StsNoticeRepository noticeRepository;

	/**
	 * 查询所有广告
	 */
	public List<StsNotice> selectAllNotice() {
		return noticeRepository.findAllByOrderByOrderNum();
	}

	public StsNotice insertNotice(StsNotice notice) {
		String id = IdUtil.objectId();
		notice.setNoticeId(id);
		Integer integer = noticeRepository.findNoticeMaxOrder();
		notice.setOrderNum(integer + 1);
		return noticeRepository.save(notice);
	}

	public void deleteNotice(String noticeId) {
		noticeRepository.deleteById(noticeId);
	}

	public StsNotice updateNotice(StsNotice notice) {
		return noticeRepository.save(notice);
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
