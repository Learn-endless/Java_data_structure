class MyException1 extends Exception{
    public MyException1(String message){
        super(message);
    }
}
public class Test2 {
    public static void func(int i) throws MyException1 {
        while(i>0){
            if(i>5){
                try{
                    throw new MyException1("我抛异常了");
                }catch (MyException1 e){
                    e.printStackTrace();
                    System.out.println("正在处理中.....");
                }
            }
            if(i==1){
                System.out.println("处理完成了");
            }
            i--;
        }
    }
    public static void main(String[] args) {
        try {
            func(10);
        } catch (MyException1 myException1) {
            myException1.printStackTrace();
        }
    }
}
