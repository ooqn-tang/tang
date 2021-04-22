package net.ttcxy.tang.gateway.core.verify;

import cn.hutool.json.JSONObject;
import net.ttcxy.tang.gateway.core.exception.VerifyException;

public abstract class VerifyAbstract {

    public JSONObject error = new JSONObject();

    /**
     * 实现 createVerify 并在最后 使用 throwError() 方法
     * @throws VerifyException 参数验证异常
     */
    public void createVerify() throws VerifyException {
        throw new VerifyException("没有重写 create 验证器",new JSONObject());
    }

    /**
     * 实现 createVerify 并在最后 使用 throwError() 方法
     * @throws VerifyException 参数验证异常
     */
    public void updateVerify() throws VerifyException {
        throw new VerifyException("没有重写 update 验证器",new JSONObject());
    }

    /**
     * 实现 createVerify 并在最后 使用 throwError() 方法
     * @throws VerifyException 参数验证异常
     */
    public void selectVerify() throws VerifyException {
        throw new VerifyException("没有重写 select 验证器",new JSONObject());
    }

    /**
     * 实现 createVerify 并在最后 使用 throwError() 方法
     * @throws VerifyException 参数验证异常
     */
    public void deleteVerify() throws VerifyException {
        throw new VerifyException("没有重写 delete 验证器",new JSONObject());
    }

    /**
     * 如果 error 对象不为空 抛出异常。
     */
    public void throwsError(){
        if (error.size() > 0){
            throw new VerifyException("error",error);
        }
    }
}
