import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-17
 * Time: 17:24
 */

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
public class MyStack {
    //创建两个队列
    public Queue<Integer> stack1;
    public Queue<Integer> stack2;

    //初始化队列
    public MyStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    //入栈方法
    public void push(int x) {
        //当队列2里面有元素时，入队
        if(stack2.size()!=0){
            stack2.offer(x);
        }else{
            //其他情况都是入队1
            stack1.offer(x);
        }
    }
    //出栈方法
    public int pop() {
        //首先判断两个队列是不是都没有元素
        if(stack1.size() == 0 && stack2.size() == 0){
            return -1;
        //如果队列1有元素，将队列1中size-1个元素入队到队列2中，剩下对头的那个就是出栈的元素
        }else if(!stack1.isEmpty()){
            //记录元素个数
            int n1 = stack1.size()-1;
            //循环处理size-1个元素
            for(int i = 0; i < n1; i++){
                int ret = stack1.poll();
                stack2.offer(ret);
            }
            //将真正的元素出栈，并返回
            return stack1.poll();
        }else{
            //与上面相同
            int n2 = stack2.size()-1;
            for(int i = 0; i < n2; i++){
                int ret = stack2.poll();
                stack1.offer(ret);
            }
            return stack2.poll();
        }
    }
    //拿到栈顶的元素，不出栈
    public int top() {
        //还是先判断是不是都是没有元素的
        if(stack1.size() == 0 && stack2.size() == 0){
            return -1;
        //如果队列1中有元素，则处理队列1中的数据
        }else if(!stack1.isEmpty()){
            int n = stack1.size()-1;
            //将前size-1个元素移动到队列2中
            for(int i = 0; i < n; i++){
                int ret = stack1.poll();
                stack2.offer(ret);
            }
            //将真正的元素从队列1中移除
            int data = stack1.poll();
            //入到队列2中
            stack2.offer(data);
            //将数据返回
            return data;
        }else{
            //如果队列2中有元素时，与上面的处理方式一样
            int n = stack2.size()-1;
            for(int i = 0; i < n; i++){
                int ret = stack2.poll();
                stack1.offer(ret);
            }
            int data = stack2.poll();
            stack1.offer(data);
            return data;
        }
    }
    //判断栈中是不是空的
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
