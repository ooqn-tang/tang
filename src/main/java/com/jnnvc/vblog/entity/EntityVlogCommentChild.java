package com.jnnvc.vblog.entity;

import java.util.Date;

public class EntityVlogCommentChild {
    private Integer id;

    private Integer commentId;

    private Integer crateUser;

    private String childCommentsContent;

    private Integer childCommentsNum;

    private String childCommentStatus;

    private Integer upperLevelId;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCrateUser() {
        return crateUser;
    }

    public void setCrateUser(Integer crateUser) {
        this.crateUser = crateUser;
    }

    public String getChildCommentsContent() {
        return childCommentsContent;
    }

    public void setChildCommentsContent(String childCommentsContent) {
        this.childCommentsContent = childCommentsContent == null ? null : childCommentsContent.trim();
    }

    public Integer getChildCommentsNum() {
        return childCommentsNum;
    }

    public void setChildCommentsNum(Integer childCommentsNum) {
        this.childCommentsNum = childCommentsNum;
    }

    public String getChildCommentStatus() {
        return childCommentStatus;
    }

    public void setChildCommentStatus(String childCommentStatus) {
        this.childCommentStatus = childCommentStatus == null ? null : childCommentStatus.trim();
    }

    public Integer getUpperLevelId() {
        return upperLevelId;
    }

    public void setUpperLevelId(Integer upperLevelId) {
        this.upperLevelId = upperLevelId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}