import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-17
 * Time: 17:10
 */
public class Solution2 {
    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * @param s 给定的字符串
     * @return 返回一个true或false
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //遍历整个字符串，如果是左括号，就往栈里添加
        for(int i = 0; i < s.length(); i++){
            //如果是左括号，就往栈里添加
            if(s.charAt(i) == '('||s.charAt(i) == '['||s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                //走到这里如果发现栈为空，那么必然是前面没有左括号，在这里又发现了右括号
                if(stack.isEmpty()){
                    //直接返回false
                    return false;
                }
                //走到这里时，查看当前栈顶的括号与我拿到的括号是否匹配
                char ret = stack.peek();
                if(ret == '('&&s.charAt(i)==')'||ret == '['&&s.charAt(i)==']'||ret == '{'&&s.charAt(i)=='}'){
                    //匹配的话就出栈
                    stack.pop();
                }else{
                    //只要发现有一对不匹配，就返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
