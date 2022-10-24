package cn.ttcxy.entity.param;

import lombok.Data;

@Data
public class UtsLoginParam {

	private String username;

	private String password;

	private Boolean rememberMe;
}
