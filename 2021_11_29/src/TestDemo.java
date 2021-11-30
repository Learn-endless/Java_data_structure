public class TestDemo {
    public static void main(String[] args){
        int a = 0;
        if(a == 0){
            throw new MyRuntimeException("除0错误");
        }
        System.out.println(10/a);
    }
}






