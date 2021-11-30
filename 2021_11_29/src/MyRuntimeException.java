//这是一个自定义的非受查异常。
public class MyRuntimeException extends RuntimeException{
    //构造方法
    public MyRuntimeException(String message){
        super(message);
    }
}
