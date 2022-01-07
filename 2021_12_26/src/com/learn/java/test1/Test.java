package com.learn.java.test1;

public class Test {
    public static void main(String[] args) {
        MyLinkedList m = new MyLinkedList();
        m.addLast(4);
        m.addLast(2);
        m.addLast(1);
        m.addLast(3);
        m.display();
        System.out.println("--------------------");
        Solution s = new Solution();
        ListNode tmp = s.sortList(m.head);
        m.displayMyLinkedList(tmp);
    }
}
