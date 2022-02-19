package net.ttcxy.tang.portal.entity.param;

import java.util.List;

public class DtsCommentParam {

    private String dataId;

    private String parentCommentId;

    private String text;

    private List<String> atAuthorId;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAtAuthorId() {
        return atAuthorId;
    }

    public void setAtAuthorId(List<String> atAuthorId) {
        this.atAuthorId = atAuthorId;
    }
}
