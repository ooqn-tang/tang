package net.ttcxy.tang.entity.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author huanglei
 */
@Data
public class UtsResourceDto {

    private String id;

    private String parentId;

    private String node;

    private String path;

    private String name;

    private String level;

    private String type;

    private Date createTime;

    private List<UtsRoleDto> utsRoleDtoList;
}
