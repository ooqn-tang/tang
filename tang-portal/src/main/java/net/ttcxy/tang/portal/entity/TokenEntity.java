package net.ttcxy.tang.portal.entity;

import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;

public class TokenEntity {
    String auth;
    CurrentAuthor author;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public CurrentAuthor getAuthor() {
        return author;
    }

    public void setAuthor(CurrentAuthor author) {
        this.author = author;
    }
}
