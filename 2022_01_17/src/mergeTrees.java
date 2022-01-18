/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-18
 * Time: 18:42
 */

/**
 * 617. 合并二叉树
 *给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
 * 那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 */
public class mergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //如果两个节点都是null，则返回null
        if(root1 == null && root2 == null){
            return null;
            //如果root1不为空，返回root1节点地址
        }else if(root1 != null && root2 == null){
            return root1;
            //如果root2不为空，返回root2节点的地址
        }else if(root1 == null && root2 != null){
            return root2;
        }else{
            //都不为空时，进行合并：
            //将合并后的值放到root1中
            root1.val = root1.val+root2.val;
            //递归合并左子树
            root1.left = mergeTrees(root1.left,root2.left);
            //递归合并右子树
            root1.right = mergeTrees(root1.right,root2.right);
            //返回根节点
            return root1;
        }

    }
}
