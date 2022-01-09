/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 解法1：原地修改法
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        //先判空链表
        if (head == null) {
            return null;
        }
        //不直接使用head，备份一个cur
        Node cur = head;
        //遍历链表
        while (cur != null) {
            //创建一个新节点，使它的val值与原节点的val值相等
            Node node = new Node(cur.val);
            //将新节点连接到原节点后面
            node.next = cur.next;
            cur.next = node;
            //处理下一个原节点
            cur = cur.next.next;
        }
        //重置一下cur
        cur = head;
        //遍历
        while (cur != null) {
            //判断一下原节点的random是不是null
            //不是，就进行处理
            //由于新创建节点的random值默认是null，所以不用管
            if (cur.random != null) {
                //不是，就将原节点的random指向也拷贝到新节点的random中
                //这里需要注意：
                //cur.random是原节点的值，新节点不能直接指向
                //所以只能指向那个原节点的拷贝节点
                //在上面我们就已经将每个拷贝节点放到了每个原节点的后面
                cur.next.random = cur.random.next;
            }
            //处理下一个
            cur = cur.next.next;
        }
        //存放新链表的头节点
        Node copyHead = head.next;
        cur = head;
        //拷贝一份用来循环遍历
        Node copyCur = head.next;
        while (cur != null) {
            //连接原链表
            cur.next = cur.next.next;
            cur = cur.next;
            //判断是不是尾结点
            if (copyCur.next != null) {
                //不是，继续连接新链表
                copyCur.next = copyCur.next.next;
                copyCur = copyCur.next;
            }
        }
        //返回新链表的头节点
        return copyHead;
    }
}
