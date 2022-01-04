package DoubleLinkedListTwo;

/**
 * 双链表的节点
 */
public class ListNode {
    public int val;        //当前节点中的数值
    public ListNode prev;  //前节点的地址
    public ListNode next;  //后节点的地址
    //有参构造
    public ListNode(int val){
        this.val = val;
    }
}
