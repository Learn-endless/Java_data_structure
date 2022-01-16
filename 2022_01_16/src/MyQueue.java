import java.util.Stack;

public class MyQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            int val = stack2.pop();
            return val;
        }else{
            while(!stack1.isEmpty()){
                int ret = stack1.pop();
                stack2.push(ret);
            }
            int data = stack2.pop();
            return data;
        }
    }

    public int peek() {
        if(!stack2.isEmpty()){
            int val = stack2.peek();
            return val;
        }else{
            while(!stack1.isEmpty()){
                int ret = stack1.pop();
                stack2.push(ret);
            }
            int data = stack2.peek();
            return data;
        }
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
