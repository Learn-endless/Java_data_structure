package com.learn.java.test1;
class ListNode{
    private final int val;
    private ListNode next;
    public ListNode(int data){
        this.val = data;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
/**
 * 自己写一个单链表
 */
public class MyLinkedList {
    private ListNode head;

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        //第一个节点
        if(this.head == null){
            this.head = node;
        }else{
            //第二个节点
            ListNode cur = this.head;
            while(cur.getNext() != null){
                cur = cur.getNext();
            }
            cur.setNext(node);
        }
    }

    //显示链表
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.getVal()+" ");
            cur = cur.getNext();
        }
    }
    //使用节点显示链表
    public void displayMyLinkedList(ListNode cur){
        while(cur != null){
            System.out.print(cur.getVal()+" ");
            cur = cur.getNext();
        }
    }
    //获取头节点
    public ListNode getHead(){
        return this.head;
    }
}
