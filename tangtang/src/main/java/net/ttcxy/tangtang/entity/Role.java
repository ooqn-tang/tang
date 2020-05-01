package net.ttcxy.tangtang.entity;



/**
 * 角色
 */
public class Role {

    static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
