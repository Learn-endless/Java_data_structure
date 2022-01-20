/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 20:13
 */

/**
 * 572. 另一棵树的子树
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 */
public class IsSubtree {
    //判断两颗树是否相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p != null && q == null || p == null && q != null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //由于题目规定了，两颗数的节点个数都是>=1的，所以这里就不需要判断初始值任意为空的情况
        if(root == null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }else{
            return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
        }
    }

    public static void main(String[] args) {
        System.out.println(isSubtree(null, null));
    }
}
