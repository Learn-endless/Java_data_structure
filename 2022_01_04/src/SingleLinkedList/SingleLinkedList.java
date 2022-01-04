package SingleLinkedList;
/**
 * 单链表(无头单向非循环链表)
 */
public class SingleLinkedList {
    private ListNode head;  //头节点
    //头插法
    public void addFirst(int data){
        //创建一个节点
        ListNode node = new ListNode(data);
        if(this.head == null){
            //当前是一个空链表
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        //创建一个节点
        ListNode node = new ListNode(data);
        if(this.head == null){
            //当前是一个空链表
            this.head = node;
        }else{
            ListNode cur = this.head;
            //找到最后一个节点
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //寻找插入位置的前驱
    private ListNode findPrev(int index){
        ListNode cur = this.head;
        while(index-1 > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        //判空
        if(this.head == null){
            return false;
        }
        //判断下标是否合法
        if(index > size() || index < 0){
            System.out.println("下标不合法");
            return false;
        }
        //判断是否在头节点位置插入
        if(index == 0){
            //头插法
            addFirst(data);
            return true;
        }
        //判断是不是在链表尾部插入
        if(index == size()){
            //尾插
            addLast(data);
            return true;
        }
        //创建节点
        ListNode node = new ListNode(data);
        //通过下标找前驱
        ListNode cur = findPrev(index);
        //插入
        node.next = cur.next;
        cur.next = node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //判断是不是空链表
        if(this.head == null){
            return;
        }
        ListNode cur = this.head.next;
        //首先处理一下是不是头节点
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        ListNode index = this.head;
        while(cur != null){
            if(cur.val == key){
                //找到了第一个,进行处理
                index.next = cur.next;
                return;
            }else{
                cur = cur.next;
                index = index.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head == null){
            return;
        }
        //先不处理头节点
        ListNode cur = this.head;
        ListNode prev = this.head.next;
        while(prev != null){
            if(prev.val == key){
                //找到一个处理一个
                cur.next = prev.next;
                prev = prev.next;
            }else{
                //没找到往后走
                cur = prev;
                prev = prev.next;
            }
        }
        //处理头节点
        if(this.head.val == key){
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //打印单链表
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        //换一下行
        System.out.println();
    }
    //销毁单链表（温柔一点的做法）
    public void clear(){
        while(this.head != null){
            //记录一下head的下一个节点
            ListNode prev = this.head.next;
            //head的next置空
            this.head.next = null;
            //更新head的指向
            this.head = prev;
        }
    }
}
