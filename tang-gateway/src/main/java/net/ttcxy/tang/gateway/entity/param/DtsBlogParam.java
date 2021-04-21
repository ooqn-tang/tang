package net.ttcxy.tang.gateway.entity.param;

import cn.hutool.json.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.gateway.core.api.ResultCode;
import net.ttcxy.tang.gateway.core.verify.VerifyEntity;
import net.ttcxy.tang.gateway.core.verify.VerifyException;
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
    public void createVerify() throws VerifyException {

    }

    @Override
    public void updateVerify() throws VerifyException {
        if (blog == null){
            error.put("blog","null");
        }
        throw new VerifyException("更新异常", error);
    }
}
