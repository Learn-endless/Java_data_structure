import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-05
 * Time: 23:12
 */
public class Fib {

    /**
     * 求出第 n 项斐波那契数
     * @param n 第几项
     * @return  返回那一项的斐波那契数
     */
    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }


    /**
     * 判断当前数字是不是 斐波那契 数
     * @param n 一个整数
     * @return  true 或 false
     */
    public static boolean fibNumber(int n){
        int tmp = 1;
        while(true){
            int ret = fib(tmp);
            if(n == ret){
                return true;
            }else if(ret > n){
                return false;
            }else{
                tmp++;
            }
        }
    }

    /**
     * 返回 该数字 通过 +1 或者 -1 操作 ,第几步才是 斐波那契 数字
     * @param n 输入的一个整数
     * @return  返回最少操作的次数
     */
    public static int func(int n){
        int i = n;
        int j = n;
        int sum = 0;
        while(true){
            if(fibNumber(i) || fibNumber(j)){
                return sum;
            }
            sum++;
            i+=1;
            j-=1;
        }
    }

    /**
     * 输入一个整数,判断通过 +1 或 -1 操作,最少几步能够变成一个斐波那契数
     * 斐波那契数字:1、1、2、3、5、8、13、21、34...
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int ret = func(input);
        System.out.println(ret);
    }
}
