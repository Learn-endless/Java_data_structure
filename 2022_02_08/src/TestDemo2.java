import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-09
 * Time: 16:14
 *
 * 1046. 最后一块石头的重量(LeetCode)
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class TestDemo2 {
    private int[] elem;
    private int userSize;

    public int lastStoneWeight(int[] stones) {
        this.elem = Arrays.copyOf(stones, stones.length);
        this.userSize = stones.length;
        //将数组调整为大根堆
        for(int i = (this.userSize-2)/2; i >= 0; i--){
            shiftDown(i);
        }
        while(this.userSize > 1){
            int x = pop();
            int y = pop();
            if(x != y){
                offer(Math.abs(x-y));
            }
        }
        return this.userSize==0?0:this.elem[0];
    }
    //出队
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int tmp = this.elem[0];
        //交换
        exchange(0,this.userSize-1);
        //userSize--
        this.userSize--;
        //调整
        shiftDown(0);
        return tmp;
    }
    //入队
    public void offer(int val){
        this.elem[this.userSize++] = val;
        //向上调整
        shiftUp(this.userSize - 1);
    }
    //判断是否为空
    private boolean isEmpty(){
        return this.userSize == 0;
    }
    //向上调整
    private void shiftUp(int child){
        int parent = (child-1)/2;
        while(parent >= 0){
            if(this.elem[child] > this.elem[parent]){
                //交换
                exchange(child,parent);
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }
    //向下调整
    private void shiftDown(int parent){
        int child = parent*2+1;
        while(child < this.userSize){
            if(child+1 < this.userSize && this.elem[child+1]>this.elem[child]){
                child++;
            }
            if(this.elem[parent] < this.elem[child]){
                //交换
                exchange(parent,child);
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }
    }
    //交换
    private void exchange(int x, int y){
        int tmp = this.elem[x];
        this.elem[x] = this.elem[y];
        this.elem[y] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {7,5,6,9,10,5};
        TestDemo2 n = new TestDemo2();
        int ret = n.lastStoneWeight(data);
        System.out.println(ret);
    }
}
