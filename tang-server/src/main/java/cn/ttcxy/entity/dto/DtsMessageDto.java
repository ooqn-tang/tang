package cn.ttcxy.entity.dto;

import cn.ttcxy.entity.model.DtsMessage;
import cn.ttcxy.entity.model.UtsAuthor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsMessageDto {

	private DtsMessage message;

	private UtsAuthor author;

	
}
