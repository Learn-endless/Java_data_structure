/**
 * 多组输入，每次输入一串字符串（其中只有大小写字母）
 * 输出一串新的字符串，要求：没有重复，并且升序排列
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 自定义比较器
 */
class MyCompator implements Comparator<Character>{

    @Override
    public int compare(Character o1, Character o2) {
        return o2>o1?1:-1;
    }
}

public class StrTest {
    /**
     * 另一种想法,降序排列
     * 需要使用自定义比较器
     * 1.将基本数据类型的数据转换为应用数据类型的数据
     * 2.写一个自定义比较器
     * @param data
     * @return
     */
    public static String func3(String data){
        StringBuilder str = new StringBuilder();
        int[] num = new int[58]; //65-122,0-57,一共58个元素
        for (int i = 0; i < data.length(); i++) {
            char ret = data.charAt(i);
            //当这个字符第一次出现时，append到str后面
            if(num[ret-65] == 0){
                str.append(ret);
                num[ret - 65] = 1;
            }
        }
        char[] t = str.toString().toCharArray();
        Character[] n = new Character[t.length];
        for (int i = 0; i < t.length; i++) {
            n[i] = t[i];
        }
        MyCompator m = new MyCompator();
        Arrays.sort(n,m);
        StringBuilder i = new StringBuilder();
        for (char x:n) {
            i.append(x);
        }
        return i.toString();
    }

    /**
     * 方法二，使用一个int[]数组来统计字符出现的次数
     * @param data
     * @return
     */
    public static String func2(String data){
        StringBuilder str = new StringBuilder();
        int[] num = new int[57]; //65-122
        for (int i = 0; i < data.length(); i++) {
            char ret = data.charAt(i);
            num[ret-65]++;  //整形数组中字符对应的ASCII码下标的值加1
        }
        //重新遍历，只要不是为0，就说明该字符至少有一个，就加到str后面去
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0){
                str.append((char)(i+65));
            }
        }
        return str.toString();  //该方法的返回值为一个新的String类型的对象
    }

    /**
     * 常用方法：使用字符串的库函数解决
     * @param data  接收键盘输入的字符串
     */
    public static <T> String func1(String data){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            //获取到字符串中的每个字符
            char tmp = data.charAt(i);
            //判断是否在str中，没有就添加
            if(!str.toString().contains(tmp+"")){
                //注意这里StringBuilder类中没有contains方法
                //并且contains的参数没有字符，只有字符串
                str.append(tmp);
            }
        }
            char[] ret = str.toString().toCharArray();
        Arrays.sort(ret);  //排序默认升序
        return String.valueOf(ret);  //valueof(char[] data)将一个字符数组转换成一个字符串
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //首先是多组输入
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String ret = func3(str);
            System.out.println(ret);
        }
    }
}
