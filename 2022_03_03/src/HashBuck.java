/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-04
 * Time: 18:39
 */

import java.util.Objects;

/**
 * (复习 哈希桶)
 * 自定义一个 哈希桶
 */
public class HashBuck {
    /**
     * 节点类
     */
    static class Node{
        public int key;
        public int value;
        public Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    //定义一个数组用来存放每条链表
    private Node[] array;
    //用来记录 哈希表 中存放元素的个数
    private int usedSize;
    //定义一个负载因子
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    //哈希表有一个无参构造方法
    public HashBuck(){
        this.array = new Node[10];
    }

    //想哈希表存放元素 -- put 方法
    public void put(int key,int value){
        //1.先找到到 key 值所对应的下标
        int index = key % this.array.length;

        //2.再处理一下如果在当前的 哈希表 中存在 key 的值,那么我们需要 对 它的 value 值进行更新
        Node cur = this.array[index];
        while(cur != null){
            if(cur.key == key){
                //更新value
                cur.value = value;
                //这次插入结束
                return;
            }
            cur = cur.next;
        }

        //3.走到这里说明没有 key 的值,可以进行添加元素了.
        Node node = new Node(key,value);
        //使用头插法 插入该元素
        node.next = this.array[index];
        this.array[index] = node;
        this.usedSize++;


        //4.每次插入完数据后,就需要检查一下负载因子,看看是不是需要扩容
        if(checkLoadFactor()){
            //说明需要扩容了
            arrayDilatation();
        }
    }

    /**
     * 扩容方法
     */
    private void arrayDilatation(){
        Node[] tmp = new Node[this.array.length*2];
        //有了一块空间之后,我们就需要进行二次哈希
        for (Node cur:this.array) {
            while(cur != null){
                //计算当前元素在 tmp 中应该存放位置的下标
                int index = cur.key%tmp.length;
                //头插法插入
                Node curNext = cur.next;   //记录一下 cur 的下一个元素的 地址
                cur.next = tmp[index];
                tmp[index] = cur;
                cur = curNext;             //往下一个元素走
            }
        }
        this.array = tmp;
    }

    /**
     * 检查当前哈希表是否需要扩容
     * @return  一个boolean值
     */
    private boolean checkLoadFactor(){
        return 1.0 * this.usedSize / this.array.length > DEFAULT_LOAD_FACTOR;
    }


    //获取 key 值所对应的 value 值
    public int get(int key){
        //1.拿到 key 所对应的下标
        int index = key%this.array.length;
        //2.遍历当前下标下的链表看看有没有;
        Node cur = this.array[index];
        while(cur != null){
            if(cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
        //找不到返回一个 -1
        return -1;
    }
}
