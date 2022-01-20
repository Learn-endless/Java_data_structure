/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 20:42
 */

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsBalanced {
//=============方法二=============
    //一边求高度，一边判断是否满足平衡条件
    public int height1(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height1(root.left);
        int right = height1(root.right);
        if(left != -1 && right != -1 && Math.abs(left - right) <= 1){
            //返回当前高度
            return Math.max(left,right)+1;
        }else{
            //不满足直接返回-1
            return -1;
        }
    }
    public boolean isBalanced1(TreeNode root) {
        if (height1(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
//=============方法一=============
    //求高度
    public int height2(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height2(root.left),height2(root.right))+1;
    }
    //通过条件进行筛选，看看每颗子树的高度差是不是小于等于1
    public boolean isBalanced2(TreeNode root) {
        if(root == null){
            return true;
        }
        //求高度差
        if(Math.abs(height2(root.left) - height2(root.right)) <= 1){
            //满足条件进行下一颗树的判断
            return isBalanced2(root.left) && isBalanced2(root.right);
        }else{
            return false;
        }
    }
}
