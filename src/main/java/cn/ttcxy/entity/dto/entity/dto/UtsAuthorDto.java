package cn.ttcxy.entity.dto.entity.dto;

import cn.ttcxy.entity.model.UtsAuthor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode
public class UtsAuthorDto  {

    private UtsAuthor utsAuthor;

    private Set<UtsRoleDto> utsRoleDto;

}
