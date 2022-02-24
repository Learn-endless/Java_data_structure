package com.bit.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-24
 * Time: 14:38
 */
class Node{
    public int val;
    public Node next;
    public Node random;
    public Node(int val){
        this.val = val;
    }
}

public class TestDemo6 {
    /**
     * 138. 复制带随机指针的链表
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     *
     * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
     * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
     * 复制链表中的指针都不应指向原链表中的节点 。
     *
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     *
     * 返回复制链表的头节点。
     *
     * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
     *
     * val：一个表示Node.val的整数。
     * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     */
    public Node copyRandomList(Node head) {
        //先判空
        if(head == null){
            return null;
        }
        //用 Map 来进行操作
        Map<Node,Node> map = new HashMap<>();
        //将原链表当作 key 值，然后映射一个个新的节点
        for(Node cur = head; cur != null; cur = cur.next){
            map.put(cur,new Node(cur.val));
        }
        //将每个新节点的 next 和 random 值都连接起来
        for(Node cur = head; cur != null; cur = cur.next){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        //返回原链表头节点所映射的节点
        return map.get(head);
    }
}
