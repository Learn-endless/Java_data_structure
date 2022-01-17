import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-17
 * Time: 18:13
 */

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class MyQueue {
    //创建两个栈
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    //初始化
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    //每次都将数据放到栈1中
    public void push(int x) {
        stack1.push(x);
    }
    //出队方法
    public int pop() {
        //如果栈2不为空
        if(!stack2.empty()){
            //直接从里面出
            return stack2.pop();
        }else{
            //栈2为空时，需要先将栈1的数据都放到栈2里去
            while(!stack1.empty()){
                int ret = stack1.pop();
                stack2.push(ret);
            }
            //最后返回栈1栈顶的元素，就是我们需要出队的数据
            return stack2.pop();
        }
    }
    //查看对头的元素
    public int peek() {
        //与pop方法大致相同
        if(!stack2.empty()){
            //这里改成peek（）方法，不删除
            return stack2.peek();
        }else{
            while(!stack1.empty()){
                int ret = stack1.pop();
                stack2.push(ret);
            }
            //这里也改为peek（）方法
            return stack2.peek();
        }
    }
    //判断队列是否为空
    public boolean empty() {
        //两个栈都为空，说明没有数据
        return stack1.empty() && stack2.empty();
    }
}
