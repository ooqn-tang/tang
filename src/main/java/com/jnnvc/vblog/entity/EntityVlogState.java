package com.jnnvc.vblog.entity;

import java.util.Date;

public class EntityVlogState {
    private Integer id;

    private Integer vlogId;

    private Integer playTimes;

    private Integer amountDownloads;

    private Date lastPlay;

    private Integer commentsNum;

    private Integer criticismNum;

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

    public Integer getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(Integer playTimes) {
        this.playTimes = playTimes;
    }

    public Integer getAmountDownloads() {
        return amountDownloads;
    }

    public void setAmountDownloads(Integer amountDownloads) {
        this.amountDownloads = amountDownloads;
    }

    public Date getLastPlay() {
        return lastPlay;
    }

    public void setLastPlay(Date lastPlay) {
        this.lastPlay = lastPlay;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Integer getCriticismNum() {
        return criticismNum;
    }

    public void setCriticismNum(Integer criticismNum) {
        this.criticismNum = criticismNum;
    }
}