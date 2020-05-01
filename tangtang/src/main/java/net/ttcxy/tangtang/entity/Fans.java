package net.ttcxy.tangtang.entity;

import java.util.Date;

/**
 * @author ：HuangLei
 * @date ：2020/4/10 0010 19:52
 */
public class Fans {

    private String id;

    private String userId;

    private String follower;

    private Date createDate;

    public Fans(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
