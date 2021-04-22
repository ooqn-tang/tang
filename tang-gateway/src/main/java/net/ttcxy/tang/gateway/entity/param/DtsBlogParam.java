package net.ttcxy.tang.gateway.entity.param;

import lombok.Data;
import net.ttcxy.tang.gateway.core.exception.VerifyException;
import net.ttcxy.tang.gateway.core.verify.VerifyAbstract;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author huanglei
 */
@Data
public class DtsBlogParam extends VerifyAbstract {

    @NotNull
    private DtsBlog blog;

    @NotNull
    private UtsAuthor author;

    @Override
    public void createVerify() throws VerifyException {

    }

    @Override
    public void updateVerify() throws VerifyException {

    }
}
