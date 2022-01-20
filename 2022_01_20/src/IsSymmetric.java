/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 20:50
 */

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {
    public boolean isSymmetricChild(TreeNode q,TreeNode p){
        //左子树与右子树都是空树时返回true
        if(q == null && p == null){
            return true;
            //一个为null一个不为null时返回false
        }else if(q == null || p == null){
            return false;
            //数值不相同时，也要返回false
        }else if(q.val != p.val){
            return false;
        }else{
            //只有当左子树与右子树都对称时才会返回true
            return isSymmetricChild(q.left,p.right)&&isSymmetricChild(q.right,p.left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        //如果是一个空树，返回true
        if(root == null){
            return true;
        }
        //判断左子树与右子树是否对称
        return isSymmetricChild(root.left,root.right);
    }
}
