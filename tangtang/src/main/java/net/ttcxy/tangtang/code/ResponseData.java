package net.ttcxy.tangtang.code;

import lombok.Data;

/**
 * 返回
 */
@Data
public class  ResponseData<T> {

    private String state;

    private String msg;

    private T data;

    private ResponseData(String state, String msg, T data){
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    private ResponseData(){}

    public static <T> ResponseData successful(T data){
        ResponseData responseData  = new ResponseData("00","成功",data);
        return responseData ;
    }

    /**
     * 失败
     * @param msg 给人看的提示
     * @return
     */
    public static ResponseData error(String msg){
        ResponseData responseData = new ResponseData("44",msg,"");
        return responseData;
    }

}
