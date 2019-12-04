package net.ttcxy.tangtang.entity;

import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2019/11/30 0030 21:01
 */
public class Special {

    private String sid;

    private String uid;

    private String title;

    private String createDate;

    private List<Blog> specialBlogs;

    public List<Blog> getSpecialBlogs() {
        return specialBlogs;
    }

    public void setSpecialBlogs(List<Blog> specialBlogs) {
        this.specialBlogs = specialBlogs;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
