package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsMessage implements Serializable {
    private String messageId;

    private String authorId;

    private String recipientAuthorId;

    private Date createDate;

    private String text;

    private String url;

    private String title;

    private static final long serialVersionUID = 1L;

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

    public String getRecipientAuthorId() {
        return recipientAuthorId;
    }

    public void setRecipientAuthorId(String recipientAuthorId) {
        this.recipientAuthorId = recipientAuthorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", authorId=").append(authorId);
        sb.append(", recipientAuthorId=").append(recipientAuthorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", text=").append(text);
        sb.append(", url=").append(url);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}