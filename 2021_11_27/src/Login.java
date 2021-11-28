class MyException extends  Exception{
    public MyException(String message){
        super(message);
    }
}
class MyException2 extends  Exception{
    public MyException2(String message){
        super(message);
    }
}

public class Login {
    private static final String userName = "zhangsan";
    private static final String passWord = "123456";

    public static void login(String name ,String pass) throws MyException, MyException2 {
        if(!userName.equals(name)){
            throw new MyException("用户名错误！");
        }
        if(!passWord.equals(pass)){
            throw new MyException2("密码错误！");
        }
    }

    public static void main(String[] args) {
        try {
            login("zhagn","123");
        } catch (MyException | MyException2 e) {
            e.printStackTrace();
            System.out.println("出现了异常！");
        }
        System.out.println("已经被成功处理了！");
    }
}
