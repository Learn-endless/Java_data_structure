import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 解法2：哈希表
 */
public class Solution2 {
    public Node copyRandomList(Node head) {
        //先判空
        if(head == null){
            return null;
        }
        //创建一个HashMap
        Map<Node,Node> map = new HashMap<>();
        for(Node cur = head; cur != null; cur = cur.next){
            //将原节点拷贝一份放到集合中（这时只有val值相同）
            map.put(cur,new Node(cur.val));
        }
        for(Node cur = head; cur != null;cur = cur.next){
            //通过next值将所有拷贝的节点连接到一起
            map.get(cur).next = map.get(cur.next);
            //拷贝原节点中random的值
            map.get(cur).random = map.get(cur.random);
        }
        //返回原节点作为键时所对应的新链表的头节点
        return map.get(head);
    }
}
