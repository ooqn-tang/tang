package net.ttcxy.tangtang.code;

/**
 * 返回
 * @author Huanglei
 */
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
