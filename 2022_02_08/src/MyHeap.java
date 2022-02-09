import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-08
 * Time: 15:46
 */
public class MyHeap {
    private int[] elem;
    private int userSize;

    public MyHeap(){
        this.elem = new int[10];
    }
    //交换方法
    private void exchange(int x ,int y){
        int tmp = this.elem[x];
        this.elem[x] = this.elem[y];
        this.elem[y] = tmp;
    }

    //想下调整方法
    private void shiftDown(int parent){
        int child = parent*2+1;
        while(child < this.userSize){
            //ret始终指向最大的那个孩子
            if(child+1 < this.userSize && this.elem[child] < this.elem[child+1]){
                child++;
            }
            //判断孩子节点与父亲节点的大小
            if(this.elem[parent] < this.elem[child]){
                //交换
                exchange(parent,child);
                //更新
                parent = child;
                child = parent*2+1;
            }else{
                //不大说明调整完了
                break;
            }
        }
    }
    //创建一个堆
    public void creatHeap(int[] array){
        this.elem = Arrays.copyOf(array,array.length);
        this.userSize += array.length;

        for(int i = (this.userSize-2)/2; i >= 0; i--){
            //调整
            shiftDown(i);
        }
    }
    //添加元素
    public void offer(int val){
        //先判断是否满了
        if(isFull()){
            //扩容-1.5倍
            this.elem = Arrays.copyOf(elem,this.elem.length+(this.elem.length >> 1));
        }
        //放元素
        this.elem[this.userSize++] = val;
        //向上调整
        shiftUp(this.userSize - 1);
    }
    //判断是否满了
    private boolean isFull(){
        return this.userSize == this.elem.length;
    }
    //向上调整方法
    private void shiftUp(int child){
        int parent = (child-1)/2;
        while(parent >= 0){
            //将插入的数据与parent进行比较
            if(this.elem[child] > this.elem[parent]){
                //交换
                exchange(child,parent);
                //向上调整
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }
    //出队函数
    public int poll(){
        //先判断该优先级队列是否为空
        if(isEmpty()){
            throw new RuntimeException("优先级队列为空！");
        }
        //先交换根节点和最后一个叶子节点
        exchange(0,this.userSize-1);
        //将出队的数据存一份
        int val = this.elem[this.userSize-1];
        //userSize--
        this.userSize--;
        //调整下标为0的这棵树
        shiftDown(0);
        return val;
    }
    //判断优先级队列是否为空
    public boolean isEmpty(){
        return this.userSize == 0;
    }
    //查看队首元素
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("优先级队列为空！");
        }
        return this.elem[0];
    }
}
