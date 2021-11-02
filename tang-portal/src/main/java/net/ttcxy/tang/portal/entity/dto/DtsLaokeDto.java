package net.ttcxy.tang.portal.entity.dto;

import java.util.Date;

public class DtsLaokeDto {

    private String laokeId;

    private String authorId;

    private String nickname;

    private String text;

    private String type;

    private Date createDate;

    public String getLaokeId() {
        return laokeId;
    }

    public void setLaokeId(String laokeId) {
        this.laokeId = laokeId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
