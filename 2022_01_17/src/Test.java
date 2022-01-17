import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-17
 * Time: 18:27
 */
public class Test {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Test() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            int i = stack1.size()-1;
            while(i-->0){
                int ret = stack1.pop();
                stack2.push(ret);
            }
            return stack1.pop();
        }
    }

    public int peek() {
        if(!stack2.empty()){
            return stack2.peek();
        }else{
            int i = stack1.size()-1;
            while(i-->0){
                int ret = stack1.pop();
                stack2.push(ret);
            }
            return stack1.peek();
        }
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
