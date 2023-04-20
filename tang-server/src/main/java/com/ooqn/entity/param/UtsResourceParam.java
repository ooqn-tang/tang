package com.ooqn.entity.param;

import java.util.Date;
import lombok.Data;

@Data
public class UtsResourceParam {

	private String resourceId;

	private String path;

	private String name;

	private String type;

	private Date createTime;
}
