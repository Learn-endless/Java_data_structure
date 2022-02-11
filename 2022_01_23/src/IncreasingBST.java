/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-11
 * Time: 17:14
 */
public class IncreasingBST {
    //记录前一个处理的节点地址
    private TreeNode prev = null;

    /*
    897. 递增顺序搜索树
    给你一棵二叉搜索树的root，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
    并且每个节点没有左子节点，只有一个右子节点。
     */
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        //当前二叉树一直往左子树走，最后一个就是新二叉树的根节点
        TreeNode cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        //调用中序遍历方法进行二叉树的处理
        inorder(root);
        //返回先前记录的根节点
        return cur;
    }
    //中序遍历进行处理
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        //先 左子树 递归
        inorder(root.left);
        //每颗 左子树 指向 null
        root.left = null;
        //第一次进来的时候prev还是null
        if(prev != null){
            prev.right = root;
        }
        //更新prev的指向
        prev = root;
        //递归 右子树
        inorder(root.right);

    }
}
