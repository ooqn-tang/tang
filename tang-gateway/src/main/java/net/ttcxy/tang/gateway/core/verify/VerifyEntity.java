package net.ttcxy.tang.gateway.core.verify;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;

public abstract class VerifyEntity {

    public JSONObject error = new JSONObject();

    public void createVerify() throws VerifyException {
        throw new VerifyException("没有重写 create 验证器",new JSONObject());
    }

    public void updateVerify() throws VerifyException {
        throw new VerifyException("没有重写 update 验证器",new JSONObject());
    }

    public void selectVerify() throws VerifyException {
        throw new VerifyException("没有重写 select 验证器",new JSONObject());
    }

    public void deleteVerify() throws VerifyException {
        throw new VerifyException("没有重写 delete 验证器",new JSONObject());
    }

    public void throwsError(){
        if (error != null){
            throw new VerifyException("1",error);
        }
    }
}
