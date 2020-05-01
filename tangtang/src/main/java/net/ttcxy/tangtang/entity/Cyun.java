package net.ttcxy.tangtang.entity;



import java.util.List;

/**
 * 收藏
 */

public class Cyun {

    //所有的收藏人列表
    private List<User> cyunUsers ;

    //最新收藏时间
    private String dateTime;

    //link
    private String link;

    //标题
    private String title;

    //内容
    private String text;

    //评论数
    private Integer commentCount;

    //点赞数
    private Integer praiseCount;

    public List<User> getCyunUsers() {
        return cyunUsers;
    }

    public void setCyunUsers(List<User> cyunUsers) {
        this.cyunUsers = cyunUsers;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }
}
