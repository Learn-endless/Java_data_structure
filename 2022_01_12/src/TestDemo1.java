import java.util.ArrayList;

/**
 * 去掉字符串中的come
 */
public class TestDemo1 {
    public static  void main(String[] args) {
        String str1 = "we come bit";
        String str2 = "come";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            //找到每一个字符
            char ret = str1.charAt(i);
            //看看是不是come中的任意一个字符
            if(!str2.contains(ret+"")){
                //不是，添加进集合中
                list.add(ret);
            }
        }
        //输出结果
        for (Character n:list) {
            System.out.print(n);
        }
    }
}
