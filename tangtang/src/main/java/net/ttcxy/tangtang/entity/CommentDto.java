package net.ttcxy.tangtang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.ttcxy.tangtang.model.BlogComment;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：huanglei
 * @date ：2020/4/18 0018 15:14
 */
public class CommentDto extends BlogComment {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy.MM.dd",timezone = "GMT+8")
    private Date createDate;

    private String username;

    private String nickname;

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
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
