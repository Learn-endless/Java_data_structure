/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-03
 * Time: 16:23
 */
public class TestDemo1 {

    /**
     * 找到一个字符串中第一次出现的字符
     * @param str  字符串
     * @return     该字符的下标
     */
    public static int findFirstChar(String str){
        int[] array = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char n = str.charAt(i);
            array[n-97]++;
        }
        for (int i = 0; i < str.length(); i++) {
            char n = str.charAt(i);
            if(array[n-97] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abbavde";
        int i = findFirstChar(s);
        System.out.println(s.charAt(i));
    }
}
