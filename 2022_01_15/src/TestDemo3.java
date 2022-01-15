import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class TestDemo3 {
    class Solution {
        public int evalRPN(String[] tokens) {
            //用来存放整数类型的字符串
            Stack<Integer> stack = new Stack<>();
            //循环遍历字符串数组
            for(int i = 0; i < tokens.length; i++){
                //如果当前的字符串为+-*/中的任意一个
                if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                    //从栈顶拿出前两个数
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int val = 0;
                    //根据+-*/计算val的值
                    switch(tokens[i]){
                        case "+":
                            val = num1 + num2;
                            break;
                        case "-":
                            val = num1 - num2;
                            break;
                        case "*":
                            val = num1 * num2;
                            break;
                        case "/":
                            val = num1 / num2;
                            break;
                    }
                    //将计算好的值重新放入栈
                    stack.push(val);
                }else{
                    //不是符号的话，就往栈里放
                    int data = Integer.parseInt(tokens[i]);
                    stack.push(data);
                }
            }
            //栈顶的那个就是后缀表达式的计算结果
            return stack.pop();
        }
    }
}
