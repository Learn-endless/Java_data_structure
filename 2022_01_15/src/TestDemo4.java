import java.util.Stack;

/**
 * JZ31 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 1. 0<=pushV.length == popV.length <=1000
 * 2. -1000<=pushV[i]<=1000
 * 3. pushV 的所有数字均不相同
 */
public class TestDemo4 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //定义一个栈用来存放pushA的数据
        Stack<Integer> stack = new Stack<>();
        //两个指针，一个对应pushA数组，一个对应popA数组
        int j = 0;
        int i = 0;
        //循环找到pushA的每个元素
        while(i < pushA.length){
            //如果当前pushA的元素与popA的元素不相同
            if(pushA[i] != popA[j]){
                //将该元素放到栈中，判断下pushA中下一个数据
                stack.push(pushA[i]);
                i++;
            }else{
                //走到这里，说明相同，比较下一组数
                j++;
                i++;
                //如果当前栈不为空，并且栈顶的数据与popA中数据相同时
                while(j < popA.length && !stack.empty() && stack.peek()==popA[j]){
                    //将相同的数出栈
                    stack.pop();
                    //判断popA中的下一个数
                    j++;
                }
            }
        }
        //走到这里，如果栈为空，说明该弹出序列可以从该压入序列得到。
        return stack.empty();
    }
}
