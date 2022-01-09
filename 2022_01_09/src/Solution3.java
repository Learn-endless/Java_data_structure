/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Solution3 {
    public int[] reversePrint(ListNode head) {
        //用来统计节点个数
        int len = 0;
        //使用备份的cur来遍历链表
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        //重置一下cur，方便后续使用
        cur = head;
        //创建一个int[]，准备存放节点的值
        int[] data = new int[len];
        //将链表节点的值从数组最后一个元素开始依次向前存放
        for(int i = len-1; i >= 0; i--){
            data[i] = cur.val;
            cur = cur.next;
        }
        //返回数组，如果head为null，上面两次循环都进不去
        //这时走到22行时创建的就是一个空数组
        return data;
    }
}
