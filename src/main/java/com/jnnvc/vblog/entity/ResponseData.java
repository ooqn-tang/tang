package com.jnnvc.vblog.entity;

/**
 * 返回
 */
public class ResponseData {

    private Integer state;

    private String msg;

    private Object data;

    private String hint;

    private ResponseData(Integer state, String msg, Object data,String hint){
        this.state = state;
        this.msg = msg;
        this.data = data;
        this.hint = hint;
    }


    private ResponseData(){}

    public static ResponseData successful(Object data){
        ResponseData responseData  = new ResponseData(00,"成功",data,"success");
        return responseData ;
    }

    /**
     * 失败
     * @param hint 给电脑看的提示，暗示接口调用者错误原因
     * @param msg 给人看的提示
     * @return
     */
    public static ResponseData error(String hint,String msg){
        ResponseData responseData = new ResponseData(44,msg,"",hint);
        return responseData;
    }

}
