package com.ooqn.entity.dto;

import java.util.List;

import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsRole;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UtsAuthorDto {

	private UtsAuthor author;

	private List<UtsRole> roleList;

	public long getRefreshTime() {
		return author.getRefreshTime().getTime();
	}

}
