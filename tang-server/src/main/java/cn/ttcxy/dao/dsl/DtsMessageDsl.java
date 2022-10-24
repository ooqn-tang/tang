package cn.ttcxy.dao.dsl;

import cn.ttcxy.entity.dto.DtsMessageDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 动态
 */
@Component
public class DtsMessageDsl {

	public List<DtsMessageDto> selectAuthorMessage(String authorId) {
		return new ArrayList<>();
	}
}
