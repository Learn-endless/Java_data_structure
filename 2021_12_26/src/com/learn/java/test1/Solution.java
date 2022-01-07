package com.learn.java.test1;
/**
 * 剑指offer - 077
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Solution {
    /**
     * 合并方法的具体业务逻辑
     * 这里使用递归，代码显得更加简洁，也更容易理解
     * @param l1 第一条链表的头节点
     * @param l2 第二条链表的头节点
     * @return 合并后的链表头节点
     */
    public ListNode merge(ListNode l1,ListNode l2){
        //判断第一条链表为空链表的情况
        if(l1 == null){
            return l2;
        }
        //判断第二条链表为空链表的情况
        if(l2 == null){
            return l1;
        }
        //如果l1直线的节点的val值小于l2指向的val值
        if(l1.val < l2.val){
            //将头节点是l1.next的新链表与头节点为l2的原来的链表进行合并，
            //合并后的链表同样连到l1节点后面
            l1.next = merge(l1.next,l2);
            //返回l1链表的头节点
            return l1;
        }else{
            //反之，将l2节点后面一个节点开始的新链表与原l1链表合并，
            //合并后同样连到l2节点后面
            l2.next = merge(l1,l2.next);
            //返回l2链表的头节点
            return l2;
        }
    }

    public ListNode sortList(ListNode head) {
        //先判断是否是一个空链表
        if(head == null){
            return null;
        //然后判断是否只有一个节点
        }else if(head.next == null){
            return head;
        }else{
            //使用快慢指针进行分割操作
            ListNode slow = head;  //慢指针
            ListNode fast = head;  //快指针
            /*
            这里注意我们在使用while循环时，里面的条件：
            在分割时，我们不仅要拿到两条链表的头节点，还要将原来的链表真正的断开，
            所以我们在拿到第二条链表的头节点时，也要拿到头节点的前一个节点（因为这是一个单链表）
            最后将前一个节点的next置空（这一步很重要）
            故fast指针需要满足两个条件：
            1.fast为尾结点时停下来。
            2.fast的下一个节点为尾结点时也要停下来。
            （这里由于我们提前就判断了，所以不需要判断 fast ！= null）
             */
            while( fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            //分割完成，l1和l2两条链表
            ListNode l1 = head;
            ListNode l2 = slow.next;
            //将原本链表的联系给断开
            slow.next = null;
            //又分别进行分割操作
            l1 = sortList(l1);
            l2 = sortList(l2);
            //最后将链表合并起来，返回头节点
            return merge(l1,l2);
        }
    }
}

