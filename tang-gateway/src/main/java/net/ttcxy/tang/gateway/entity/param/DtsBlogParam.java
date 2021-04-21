package net.ttcxy.tang.gateway.entity.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.gateway.core.verify.VerifyEntity;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;

/**
 * @author huanglei
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DtsBlogParam extends VerifyEntity {

    private DtsBlog blog;

    private UtsAuthor author;

    @Override
    public void createVerify() throws Exception {
        verify(blog.getMarkdown(),"\\d{1,10}","请输入 markdown");
    }

    @Override
    public void updateVerify() throws Exception {
        super.updateVerify();
    }



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
