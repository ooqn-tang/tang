package net.ttcxy.tang.entity.dto;

import lombok.Data;
import net.ttcxy.tang.entity.model.UtsMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author huanglei
 */
@Data
public class UtsMemberDto {

    private UtsMember utsMember;

    private Set<UtsRoleDto> utsRoleDto;

}
