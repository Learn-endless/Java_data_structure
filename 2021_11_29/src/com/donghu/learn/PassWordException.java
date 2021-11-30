package com.donghu.learn;
//自定义密码异常类
public class PassWordException extends RuntimeException{
    public PassWordException (String message){
        super(message);
    }
}
