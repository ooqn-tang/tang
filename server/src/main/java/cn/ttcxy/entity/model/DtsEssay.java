package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsEssay implements Serializable {
    private String essayId;

    private String authorId;

    private String text;

    private String url;

    private Date createTime;

    private String coverUrl;

    private String type;

    private static final long serialVersionUID = 1L;

    public String getEssayId() {
        return essayId;
    }

    public void setEssayId(String essayId) {
        this.essayId = essayId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", essayId=").append(essayId);
        sb.append(", authorId=").append(authorId);
        sb.append(", text=").append(text);
        sb.append(", url=").append(url);
        sb.append(", createTime=").append(createTime);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}