package net.ttcxy.tang.gateway.model;

import java.io.Serializable;

public class UtsGithubLogin implements Serializable {
    private String githubId;

    private String authorId;

    private String githubUrl;

    private static final long serialVersionUID = 1L;

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", githubId=").append(githubId);
        sb.append(", authorId=").append(authorId);
        sb.append(", githubUrl=").append(githubUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}