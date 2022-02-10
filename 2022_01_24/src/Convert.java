/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-10
 * Time: 17:28
 */
/*
JZ36 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
数据范围：输入二叉树的节点数 0 \le n \le 10000≤n≤1000，二叉树中每个节点的值 0\le val \le 10000≤val≤1000
要求：空间复杂度O(1)O(1)（即在原树上操作），时间复杂度 O(n)O(n)

注意:
1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
2.返回链表中的第一个节点的指针
3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
4.你不用输出双向链表，程序会根据你的返回值自动打印输出
 */
public class Convert {
    //前驱，用来记录每次root的前一个节点的地址
    public TreeNode prev = null;
    //中序遍历
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        //左子树
        inorder(root.left);
        //处理该节点的指向
        //left相当于prev
        //right相当于next
        root.left = prev;
        //只有第一次时，prev才是指向null
        if(prev != null){
            prev.right = root;
        }
        //更新prev的指向
        prev = root;
        //右子树
        inorder(root.right);
    }

    public TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        //调用方法进行处理
        inorder(pRootOfTree);
        //一直往左遍历，当一个节点的left为null时，该节点就是双向链表的头节点
        TreeNode head = pRootOfTree;
        while(head.left != null){
            head = head.left;
        }
        return head;
    }
}
