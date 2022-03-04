package net.ttcxy.tang.portal.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;

import java.util.Set;

/**
 * @author LYJ
 */
@Data
@EqualsAndHashCode
public class UtsAuthorDto  {

    private UtsAuthor utsAuthor;

    private Set<UtsRoleDto> utsRoleDto;

}
