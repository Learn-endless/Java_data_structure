package DoubleLinkedListTwo;

import java.util.List;

/**
 * 双链表
 */
public class DoubleLinkedList {
    private ListNode head;  //头节点
    //头插法
    public void addFirst(int data){
        //创建新节点
        ListNode node = new ListNode(data);
        //处理是空链表时的情况
        if(this.head == null){
            this.head = node;
        }else{
            //正常情况
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        //创建一个新节点
        ListNode node = new ListNode(data);
        //处理空链表的情况
        if(this.head == null){
            this.head = node;
        }else{
            //正常情况
            ListNode cur = this.head;
            //先找到最后一个节点
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
            node.prev = cur;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        //判断是否是空链表
        if(this.head == null){
            return false;
        }
        //判断坐标是否合法
        if(index > size() || index < 0){
            System.out.println("下标不合法!");
            return false;
        }
        //在0位置插入
        if(index == 0){
            //头插法
            addFirst(data);
            return true;
        }
        //在末尾插入
        if(index == size()){
            //尾插法
            addLast(data);
            return true;
        }
        //创建节点
        ListNode node = new ListNode(data);
        //找到需插入的节点
        ListNode cur = this.head;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
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
        //判断是否是空链表
        if(this.head == null){
            return;
        }
        //判断头节点的val值是否是key
        if(this.head.val == key){
            this.head = this.head.next;
            //前记录点清空
            this.head.prev = null;
            return;
        }
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                //判断是否是最后一个节点
                if(cur.next == null){
                    cur.prev.next = null;
                    cur.prev = null;
                    return;
                }else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    return;
                }
            }else{
                cur = cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        //判断是否为空链表
        if(this.head == null){
            return;
        }
        //先处理正常情况
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.val == key){
                if(cur.next == null){
                    cur.prev.next = null;
                    cur.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;   //该节点是与不是都要往后走
        }
        //处理头节点的情况
        if(this.head.val == key){
            this.head = this.head.next;
            if(this.head != null){
                this.head.prev = null;
            }
        }
    }
    //得到双链表的长度
    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //打印双链表
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        //换一下行
        System.out.println();
    }
    //销毁双链表
    public void clear(){
        ListNode cur = this.head;
        while(this.head != null) {
            cur = cur.next;
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;
        }
    }
}
