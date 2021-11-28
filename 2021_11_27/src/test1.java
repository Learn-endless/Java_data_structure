import java.util.InputMismatchException;
import java.util.Scanner;

public class test1 {

    /**
     * 在try语句中不要使用return语句，停不下来.
     * 想要结束程序，需要使用System.exit()
     * @param n
     * @return
     */
    public static int func1(int n){
        try{
            System.out.println(10/n);
        }catch (ArithmeticException e){
            e.printStackTrace();
            return 2;
        }finally {
            System.exit(1);
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(func1(0));
    }

    //向上抛异常，谁调用这个函数，谁来处理它。方法名上加上throws显示的告诉调用者可能会有这种类型的异常
    public static void func(int r) throws ArithmeticException{
        if(r == 0){
            throw new ArithmeticException("x =="+r);
        }
    }
    /**
     * 一般抛异常都是抛的自定义异常，库里本来就有的一般都是直接处理了
     * @param args
     */
    public static void main_3(String[] args) {
        try{
            func(0);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("有异常了");
        }
        System.out.println("程序正常结束了");
    }

    public static void main_2(String[] args) {
        //这是第二中写法，可以直接写在try的括号里面，这样try会自动执行资源的关闭
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(10 / n);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("除零异常");
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入格式异常");
        //这时，就没有主动关闭资源了
        } finally {
            System.out.println("资源已关闭");
        }
        System.out.println("程序正常结束！");
    }

    public static void main_1(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int n = sc.nextInt();
            System.out.println(10/n);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("除零异常");
        }catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("输入格式异常");
        }
        //finally一般都是用来关闭资源的，这条语句总是被执行
        finally {
            sc.close();
            System.out.println("资源已关闭");
        }
        System.out.println("程序正常结束！");
    }
}
