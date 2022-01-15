import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
 *
 * 如果相等，返回 true ；否则，返回 false 。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class TestDemo2 {
    public static boolean backspaceCompare(String s, String t) {
        //stack1用来存放s字符串的内容
        Stack<Character> stack1 = new Stack<>();
        //stack2用来存放t字符串的内容
        Stack<Character> stack2 = new Stack<>();
        //循环存放stack1
        for(int i = 0;i < s.length(); i++){
            //当前栈不为空且当前字符为#时，出栈一次
            if(!stack1.empty() && s.charAt(i) == '#'){
                stack1.pop();
            }else{
                //当前的字符不是#才可入栈
                if(s.charAt(i) != '#'){
                    stack1.push(s.charAt(i));
                }
            }
        }
        //循环存放stack2
        for(int i = 0;i < t.length(); i++){
            //当前栈不为空且当前字符为#时，出栈一次
            if(!stack2.empty() && t.charAt(i) == '#'){
                stack2.pop();
            }else{
                //当前的字符不是#才可入栈
                if(t.charAt(i)!='#'){
                    stack2.push(t.charAt(i));
                }
            }
        }
        //循环比较两个栈中间的数据是否相同，while两个栈都不为空
        while(!stack1.empty() && !stack2.empty()){
            //查看一下当前栈顶的元素是否相同
            if(stack1.peek() != stack2.peek()){
                //不相同直接返回false
                return false;
            }
            //下一组数据
            stack1.pop();
            stack2.pop();
        }
        //如果有一个栈的元素多，一个少，走到这里返回false。
        //只有当两个栈都是空时，走到这里才是相同的。
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        boolean ret = backspaceCompare(s,t);
        System.out.println(ret);
    }
}
