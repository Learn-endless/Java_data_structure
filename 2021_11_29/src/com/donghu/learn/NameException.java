package com.donghu.learn;
//自定义用户名异常类
public class NameException extends RuntimeException{
    public NameException(String message){
        super(message);
    }
}
