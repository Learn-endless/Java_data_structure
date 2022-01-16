
import java.util.LinkedList;
import java.util.Queue;

/**
 * 写一个RecentCounter类来计算特定时间范围内最近的请求。
 *
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，
 * 并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。(说明给的数据是一个升序排列的数据)
 */
public class TestDemo1 {
    //定义一个队列
    public static Queue<Integer> q;
    public TestDemo1() {
        //初始化队列
        this.q = new LinkedList<>();
    }
    public static int ping(int t) {
        //不为空的情况下以此判断队列中的元素
        while(!q.isEmpty()){
            //看看队头的数据符不符合要求
            if(q.peek() < (t-3000)){
                //符合去掉
                q.poll();
            }else{
                //不符合，说明后面也都不符合，跳出循环
                break;
            }
        }
        //将新数据入队
        q.offer(t);
        //返回当前队中的数据个数
        return q.size();
    }

    public static void main(String[] args) {
        int[] num = {1,100,3001,3002};
        for (int n:num) {
            int ret = ping(n);
            System.out.println(ret);

        }
    }
}
