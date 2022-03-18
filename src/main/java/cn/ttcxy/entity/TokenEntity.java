package cn.ttcxy.entity;

import cn.ttcxy.entity.dto.CurrentAuthor;

public class TokenEntity {
    private String authorities;
    private CurrentAuthor author;

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public CurrentAuthor getAuthor() {
        return author;
    }

    public void setAuthor(CurrentAuthor author) {
        this.author = author;
    }
}
