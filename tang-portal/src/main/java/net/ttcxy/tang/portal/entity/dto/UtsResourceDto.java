package net.ttcxy.tang.portal.entity.dto;

import java.util.Date;
import java.util.List;

/**
 * @author huanglei
 */
public class UtsResourceDto {

    private Integer id;

    private String parentId;

    private String node;

    private String path;

    private String name;

    private String level;

    private String type;

    private Date createTime;

    private List<UtsRoleDto> utsRoleDtoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<UtsRoleDto> getRoleDtoList() {
        return utsRoleDtoList;
    }

    public void setRoleDtoList(List<UtsRoleDto> utsRoleDtoList) {
        this.utsRoleDtoList = utsRoleDtoList;
    }
}