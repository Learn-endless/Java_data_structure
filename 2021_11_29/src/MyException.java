//这是一个自定义异常，并且也是一个受查异常
public class MyException extends Exception{
    //一个有参的构造方法
    public MyException(String message){
        super(message);
    }
}
