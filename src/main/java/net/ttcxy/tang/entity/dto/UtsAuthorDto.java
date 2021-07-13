package net.ttcxy.tang.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.entity.model.UtsAuthor;

import java.util.Set;

/**
 * @author huanglei
 */
@Data
@EqualsAndHashCode
public class UtsAuthorDto  {

    private UtsAuthor utsAuthor;

    private Set<UtsRoleDto> utsRoleDto;

}
