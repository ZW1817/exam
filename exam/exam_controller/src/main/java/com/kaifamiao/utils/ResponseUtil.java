package com.kaifamiao.utils;

import lombok.Data;

@Data
public class ResponseUtil {

    private Integer code;

    private Object msg;

    private Object data;

    public ResponseUtil(){}

    public ResponseUtil(Integer code,Object msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public static ResponseUtil ok(){
        return new ResponseUtil(1,"登录成功",null);
    }

    public static ResponseUtil ok(String msg){
        return new ResponseUtil(1,msg,null);
    }

    public static ResponseUtil ok(String msg,Object data){
        return new ResponseUtil(1,msg,data);
    }

    public static ResponseUtil error(String msg){
        return new ResponseUtil(0,msg,null);
    }

    public static ResponseUtil error(String msg,Object data){
        return new ResponseUtil(0,msg,data);
    }

    public static ResponseUtil ok(Integer code,String msg, Object data){ return new ResponseUtil(code,msg,data);}
}
