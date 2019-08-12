package com.jnnvc.vblog.data;

/**
 * 返回
 */
public class ResponseData {

    private int state;

    private String msg;

    private Object data;

    private ResponseData(int state, String msg, Object data){}

    private ResponseData(int state, String msg){}

    private ResponseData(){}

    public static ResponseData successful(Object data){
        ResponseData responseData  = new ResponseData(00,"成功",data);
        return responseData ;
    }

    public static ResponseData error(String msg){
        ResponseData responseData = new ResponseData(44,msg);
        return responseData;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
