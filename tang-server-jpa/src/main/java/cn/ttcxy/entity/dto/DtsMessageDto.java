package cn.ttcxy.entity.dto;

import java.io.Serializable;
import java.util.Date;

public class DtsMessageDto implements Serializable {
    private String messageId;

    private String authorId;

    private Date createDate;

    private String text;

    private String title;

    private String username;

    private String url;

    private String nickname;

    private static final long serialVersionUID = 1L;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DtsMessageDto{" +
                "messageId='" + messageId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", createDate=" + createDate +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}