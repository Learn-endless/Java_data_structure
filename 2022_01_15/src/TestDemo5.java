import java.util.Stack;

/**
 * 682. 棒球比赛
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 */
public class TestDemo5 {
    public int calPoints(String[] ops) {
        //创建一个栈，要来统计
        Stack<Integer> stack = new Stack<>();
        //遍历整个操作记录的字符串数组
        for(int i =0; i < ops.length; i++){
            //如果发现此时为+DC中的任意一个时，分情况处理
            if(ops[i].equals("+")||ops[i].equals("D")||ops[i].equals("C")){
                int newScore = 0;
                switch(ops[i]){
                    //如果为+，说明当前压栈的元素是前两个元素之和
                    case "+":
                        //先让栈顶出栈，方便记录前一个数据
                        int n1 = stack.pop();
                        //把前一个数据记录下来
                        int n2 = stack.peek();
                        //重新把出栈的数据又压栈回去
                        stack.push(n1);
                        //计算新数据的值
                        newScore = n1+n2;
                        //将新数据压栈
                        stack.push(newScore);
                        break;
                    //说明新数据时前一个数据的两倍
                    case "D":
                        //计算新数据
                        newScore = stack.peek()*2;
                        //放入栈空间
                        stack.push(newScore);
                        break;
                    //表示前一个数据无效
                    case "C":
                        //从栈顶出栈一个数据
                        stack.pop();
                        break;
                }
            }else{
                //正常情况，放数据
                int val = Integer.parseInt(ops[i]);
                stack.push(val);
            }
        }
        //统计总分
        int totalScore = 0;
        //当栈不为空时，从栈顶出栈
        while(!stack.empty()){
            //累加起来
            totalScore += stack.pop();
        }
        return totalScore;
    }
}
