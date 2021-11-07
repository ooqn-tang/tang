package net.ttcxy.tang.portal.entity.param;

import org.hibernate.validator.constraints.Length;

public class DtsLaokeParam {

    @Length(min = 1, max = 200, message = "长度在1 ~ 200之间")
    private String text;

    private String type;

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
}
