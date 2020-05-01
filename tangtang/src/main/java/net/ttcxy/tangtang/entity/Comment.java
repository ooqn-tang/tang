package net.ttcxy.tangtang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：HuangLei
 * @date ：2020/4/18 0018 15:14
 */
public class Comment {

    private String id;

    private String blogId;

    private String status;

    private String userId;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy:MM:dd",timezone = "GMT+8")
    private Date createDate;

    private String username;

    private String nickname;

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", blogId='" + blogId + '\'' +
                ", status='" + status + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
