package SingleLinkedList;
/**
 * 单链表测试类
 */
public class TestSingleLinkedList {
    public static void main(String[] args) {
        //创建一个链表
        SingleLinkedList m = new SingleLinkedList();
//        m.addFirst(1);
//        m.addFirst(2);
//        m.addFirst(3);
//        m.addFirst(4);
        m.addLast(2);
        m.addLast(2);
        m.addLast(3);
        m.addLast(1);
        m.display();
//        m.addIndex(4,1);
//        m.display();
//        System.out.println(m.contains(199));
//        System.out.println(m.size());
        m.remove(1);
//        m.removeAllKey(2);
//        m.clear();
        m.display();
    }
}
