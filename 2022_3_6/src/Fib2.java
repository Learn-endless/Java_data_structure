import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-05
 * Time: 23:35
 */

/**
 * 输入一个整数,判断通过 +1 或 -1 操作,最少几步能够变成一个斐波那契数
 */
public class Fib2 {
    public static int func(int n){
        int f1 = 0;
        int f2 = 1;
        int f3 = -1;
        while(f3 < n){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        //这里需要 -f1,因为在上面 循环结束的时候 ,f1里面存放的实际是 f2 的值,f2 里面存放的实际是 f3的值
        return Math.min(n-f1,f3-n);
    }


    // 斐波那契数字:1、1、2、3、5、8、13、21、34...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int ret = func(input);
        System.out.println(ret);
    }
}
