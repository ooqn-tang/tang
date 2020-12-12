package net.ttcxy.tang.admin.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.model.UtsMember;

import java.util.Set;

/**
 * @author huanglei
 */
@Data
@EqualsAndHashCode
public class UtsMemberDto {

    private UtsMember utsMember;

    private Set<UtsRoleDto> utsRoleDto;

}
