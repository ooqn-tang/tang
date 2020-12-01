package net.ttcxy.tang.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.entity.model.UtsMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
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
