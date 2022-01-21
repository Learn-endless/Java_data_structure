/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 11:14
 */
//这是二叉树的节点类
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
public class MyBinaryTree {
    //创建一个二叉树
    public TreeNode createBinaryTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        return A;
    }
    //二叉树的先序遍历
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        inorder(root.left);
        inorder(root.right);
    }
    //二叉树的中序遍历
    public void midOrder(TreeNode root){
        if(root == null){
            return;
        }
        midOrder(root.left);
        System.out.print(root.val+" ");
        midOrder(root.right);
    }
    //二叉树的后序遍历
    public void hoOrder(TreeNode root){
        if(root == null){
            return;
        }
        hoOrder(root.left);
        hoOrder(root.right);
        System.out.print(root.val+" ");
    }
    //求二叉树的节点个数
    public int totalTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        return totalTreeNode(root.left)+totalTreeNode(root.right)+1;
    }
    //求二叉树叶子节点的个数
    public int totalLeafTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else{
            return totalLeafTreeNode(root.left)+totalLeafTreeNode(root.right);
        }
    }
    //求第k层节点的个数
    public int totalLayerTreeNode(TreeNode root, int k){
        if(root == null || k < 1){
            return 0;
        }
        if(k == 1) {
            return 1;
        }else{
            return totalLayerTreeNode(root.left,k-1)+totalLayerTreeNode(root.right,k-1);
        }
    }
    //查找是否存在value值的节点
    public TreeNode findValue(TreeNode root, int value){
        if(root == null){
            return null;
        }
        if(root.val == value){
            return root;
        }
        TreeNode left = findValue(root.left,value);
        if(left != null){
            return left;
        }
        TreeNode right = findValue(root.right,value);
        if(right != null){
            return right;
        }
        return null;
    }
}
