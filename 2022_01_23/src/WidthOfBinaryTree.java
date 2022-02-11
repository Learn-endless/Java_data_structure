import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-11
 * Time: 17:10
 */
public class WidthOfBinaryTree {
    /*
    662. 二叉树最大宽度
    给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
    每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     */
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        //用来记录最大宽度
        int maxWidth = 0;
        //通过队列来进行层序遍历
        LinkedList<TreeNode> qu = new LinkedList<>();//这里需要获取 队首 和 队尾 元素
        //放入根节点,并更改root.val
        root.val = 0;
        qu.offer(root);
        while(!qu.isEmpty()){

            //计算当前层的宽度，并与所记录的最大宽度相比较
            int width = qu.getLast().val - qu.getFirst().val + 1;
            maxWidth = Math.max(maxWidth,width);

            //统计当前层有多少个节点
            int size = qu.size();
            //循环添加后续层的节点
            while(size-- != 0){
                //先出 队首 元素
                TreeNode cur = qu.poll();
                //添加节点，不为null则添加
                if(cur.left != null){
                    cur.left.val = cur.val*2+1;
                    qu.offer(cur.left);
                }
                if(cur.right != null){
                    cur.right.val = cur.val*2+2;
                    qu.offer(cur.right);
                }
            }
        }
        return maxWidth;
    }
}
