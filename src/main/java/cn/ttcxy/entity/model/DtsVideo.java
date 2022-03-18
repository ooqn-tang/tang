package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsVideo implements Serializable {
    private String videoId;

    private String title;

    private String synopsis;

    private String coverUrl;

    private String authorId;

    private Date createDate;

    private String videoUrl;

    private Integer state;

    private String videoClassId;

    private Integer checkId;

    private String checkText;

    private static final long serialVersionUID = 1L;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getVideoClassId() {
        return videoClassId;
    }

    public void setVideoClassId(String videoClassId) {
        this.videoClassId = videoClassId;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getCheckText() {
        return checkText;
    }

    public void setCheckText(String checkText) {
        this.checkText = checkText;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoId=").append(videoId);
        sb.append(", title=").append(title);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", authorId=").append(authorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", videoUrl=").append(videoUrl);
        sb.append(", state=").append(state);
        sb.append(", videoClassId=").append(videoClassId);
        sb.append(", checkId=").append(checkId);
        sb.append(", checkText=").append(checkText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}