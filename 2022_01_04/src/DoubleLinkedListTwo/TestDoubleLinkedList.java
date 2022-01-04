package DoubleLinkedListTwo;

/**
 * 测试双链表
 */
public class TestDoubleLinkedList {
    public static void main(String[] args) {
        //创建一个双链表
        DoubleLinkedList d = new DoubleLinkedList();
        d.addLast(1);
        d.addLast(1);
        d.addLast(1);
        d.addLast(1);
        d.display();
        System.out.println("------------------------");
//        d.addIndex(4,99);
//        d.display();
//        System.out.println(d.contains(5));
//        d.remove(5);
//        d.removeAllKey(1);
//        d.display();
//        System.out.println(d.size());
        d.clear();
        d.display();
    }
}
