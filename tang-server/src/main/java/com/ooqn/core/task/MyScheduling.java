package com.ooqn.core.task;

import com.ooqn.entity.model.StsNotice;
import com.ooqn.service.StsNoticeService;
import java.util.List;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 定时器
 */
@Component
@EnableScheduling
public class MyScheduling {

	@Autowired
	private StsNoticeService stsNoticeService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	public MyScheduling() {}

	/**
	 * 定时更新广告 10分钟更新一次
	 */
	@Scheduled(fixedDelay = 1000 * 60 * 10)
	public void advertiseTimerUpdate() {
		List<StsNotice> advertises = stsNoticeService.selectAllNotice();
		if (advertises != null) {
			ServletContext servletContext = webApplicationContext.getServletContext();
			if (servletContext != null) {
				servletContext.setAttribute("advertises", advertises);
			}
		}
	}

	/**
	 * 定时更新随机博客 10分钟更新一次
	 */
	@Scheduled(fixedDelay = 1000 * 60 * 10)
	public void a() {}
}
