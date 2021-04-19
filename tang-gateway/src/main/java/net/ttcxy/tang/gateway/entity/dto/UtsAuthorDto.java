package net.ttcxy.tang.gateway.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.gateway.model.UtsAuthor;

import java.util.Set;

/**
 * @author huanglei
 */
@Data
@EqualsAndHashCode
public class UtsAuthorDto {

    private UtsAuthor utsAuthor;

    private Set<UtsRoleDto> utsRoleDto;

}
