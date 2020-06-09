package net.ttcxy.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色
 * @author huanglei
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RoleDto {

    static final long serialVersionUID = 1L;

    private String id;

    private String name;

}
