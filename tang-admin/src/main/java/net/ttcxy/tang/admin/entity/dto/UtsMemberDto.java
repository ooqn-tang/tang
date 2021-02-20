package net.ttcxy.tang.admin.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author huanglei
 */
@Data
@EqualsAndHashCode
public class UtsMemberDto {

    private UtsAuthor utsAuthor;

    private Set<UtsRoleDto> utsRoleDto;

}
