/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-19
 * Time: 10:46
 */
public class Solution1 {
    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param p 一颗二叉树的根节点
     * @param q 一颗二叉树的根节点
     * @return 返回一个boolean类型的值
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //都为null，返回true
        if(p == null && q == null){
            return true;
            //其中有一个是null，返回false
        }else if(p != null && q == null || p == null && q != null){
            return false;
            //看看当前的val值是否相同
        }else if(p.val != q.val){
            return false;
        }else{
            //返回左树与右树的情况（两个都相同返回true）
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
}
