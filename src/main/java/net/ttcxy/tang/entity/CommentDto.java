package net.ttcxy.tang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import net.ttcxy.tang.model.BlogComment;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：huanglei
 * @date ：2020/4/18 0018 15:14
 */
public class CommentDto{

    private static final long serialVersionUID = 1L;

    private String id;

    private String blogId;

    @ApiModelProperty(value = "评论状态")
    private Integer status;

    @ApiModelProperty(value = "评论人")
    private String userId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy.MM.dd",timezone = "GMT+8")
    private Date createDate;

    private String username;

    private String nickname;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
}
