import java.util.Stack;

public class TestDemo1 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int num = s.length()>>1;
        for(int i = 0; i < num; i++){
            stack.push(s.charAt(i));
        }
        for(int j = num; j < s.length(); j++){
            if(stack.peek() != s.charAt(j)){
                return false;
            }else{
                stack.pop();
            }
        }
        return true;
    }

    public static void main1(String[] args) {
        String s = "()";
        boolean ret = isValid(s);
        System.out.println(ret);
    }
}
