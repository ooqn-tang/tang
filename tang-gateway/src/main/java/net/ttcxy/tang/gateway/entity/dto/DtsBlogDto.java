package net.ttcxy.tang.gateway.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;

import java.util.Date;

/**
 * Blog模型类
 * @author huanglei
 */
public class DtsBlogDto {

    private DtsBlog blog;

    private UtsAuthor author;

    public DtsBlog getBlog() {
        return blog;
    }

    public void setBlog(DtsBlog blog) {
        this.blog = blog;
    }

    public UtsAuthor getAuthor() {
        return author;
    }

    public void setAuthor(UtsAuthor author) {
        this.author = author;
    }
}
