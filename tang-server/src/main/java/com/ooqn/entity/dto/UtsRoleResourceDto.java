package com.ooqn.entity.dto;

import com.ooqn.entity.model.UtsRole;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UtsRoleResourceDto {

	private String path;
	
	Set<UtsRole> roleSet;

}
