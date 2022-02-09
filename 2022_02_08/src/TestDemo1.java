/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-08
 * Time: 16:36
 * 这是一个测试类
 */
public class TestDemo1 {
    public static void main(String[] args) {
        MyHeap m = new MyHeap();
        int[] data = {80,74,56,98,44,75,24,16,23,10};
        m.creatHeap(data);
        m.offer(100);
        System.out.println(m.poll());
        System.out.println("============");
        System.out.println(m.poll());
        System.out.println(m.poll());
        System.out.println(m.poll());
    }
}
