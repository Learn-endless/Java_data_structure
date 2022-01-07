package com.learn.java.test1;

/**
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Test077 {

    //分隔
    public static ListNode fenGe(ListNode cur){
        ListNode slow = cur;
        ListNode fast = cur;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = cur.getNext();            //走一步
            fast = cur.getNext().getNext();  //走两步
        }
        ListNode tmp = slow.getNext();
        slow.setNext(null);
        return tmp;
    }

    //合并(使用递归)
    public static ListNode heBing(ListNode x, ListNode y){
        if(x == null){
            return y;
        }else if(y == null){
            return x;
        }else{
            //如果x节点中val的值比y的大
            if(x.getVal() > y.getVal()){
                //将y节点后面的链表与x链表合并
                y.setNext(heBing(x,y.getNext()));
                //返回头节点
                return y;
            }else{
                x.setNext(heBing(x.getNext(),y));
                return x;
            }
        }
    }

    //给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    public static ListNode sortList(ListNode cur) {
        if(cur == null || cur.getNext() == null){
            return cur;
        }else{
            //分隔
            ListNode l1 = cur;
            ListNode l2 = fenGe(cur);

            //递归排序
            l1 = sortList(l1);
            l2 = sortList(l2);
            //合并
            return heBing(l1,l2);
        }
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(4);
        myLinkedList.addLast(2);
        myLinkedList.addLast(1);
        myLinkedList.addLast(3);
        myLinkedList.display();

        System.out.println("\n------------------------------");

        ListNode cur = sortList(myLinkedList.getHead());  //排序
        myLinkedList.displayMyLinkedList(cur);
    }
}
