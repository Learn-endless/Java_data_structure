/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 19:55
 */
public class IsSameTree {
    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param q 一颗二叉树的根节点
     * @param p 一颗二叉树的根节点
     * @return 返回是否相同
     */
    public static boolean isSameTree(TreeNode q, TreeNode p){
        if(q == null && p == null) {
            return true;
        }else if(q == null || p == null){
            return false;
        }else if(q.val != p.val){
            return false;
        }else{
            return isSameTree(q.left,p.left) && isSameTree(q.right,p.right);
        }
    }
}
