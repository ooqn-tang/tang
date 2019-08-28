package com.jnnvc.vblog.entity;

import java.util.Date;

public class EntityVlogComment {
    private Integer id;

    private Integer vlogId;

    private String commentStatus;

    private Integer commentUser;

    private String commentContent;

    private Integer commentsNum;

    private Integer giftFlowers;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVlogId() {
        return vlogId;
    }

    public void setVlogId(Integer vlogId) {
        this.vlogId = vlogId;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus == null ? null : commentStatus.trim();
    }

    public Integer getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(Integer commentUser) {
        this.commentUser = commentUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Integer getgiftFlowers() {
        return giftFlowers;
    }

    public void setgiftFlowers(Integer giftFlowers) {
        this.giftFlowers = giftFlowers;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}