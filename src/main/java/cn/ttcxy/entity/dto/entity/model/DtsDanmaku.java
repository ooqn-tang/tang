package cn.ttcxy.entity.dto.entity.model;

import java.io.Serializable;

public class DtsDanmaku implements Serializable {
    private String danmakuId;

    private Integer time;

    private Integer color;

    private String text;

    private String authorId;

    private String videoId;

    private static final long serialVersionUID = 1L;

    public String getDanmakuId() {
        return danmakuId;
    }

    public void setDanmakuId(String danmakuId) {
        this.danmakuId = danmakuId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", danmakuId=").append(danmakuId);
        sb.append(", time=").append(time);
        sb.append(", color=").append(color);
        sb.append(", text=").append(text);
        sb.append(", authorId=").append(authorId);
        sb.append(", videoId=").append(videoId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}