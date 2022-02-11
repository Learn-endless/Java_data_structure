/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-11
 * Time: 17:16
 */
public class BuildTree {
    /*
    105. 从前序与中序遍历序列构造二叉树
    给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历 和 中序遍历 任何一个为null时return null
        if(preorder == null || inorder == null){
            return null;
        }
        return createBinaryTree(preorder,inorder,0,inorder.length-1);
    }

    //在中序遍历数组中查找根节点
    private int findInorderIndex(int[] inorder, int begain, int end, int key){
        for(int i = begain; i <= end; i++){
            if(inorder[i] == key){
                return i;
            }
        }
        return -1;
    }

    private int prevIndex = 0;

    //创建二叉树
    private TreeNode createBinaryTree(int[] preorder,int[] inorder, int inBegain, int inEnd){
        //递归结束的条件，当右下标比左下标还小的时候，停止递归
        if(inBegain > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prevIndex]);
        //在中序遍历中查找当前root这个节点
        int inorderIndex = findInorderIndex(inorder,inBegain,inEnd,root.val);
        if(inorderIndex == -1){
            return null;
        }
        prevIndex++;
        //构建左右子树
        root.left = createBinaryTree(preorder,inorder,inBegain,inorderIndex-1);
        root.right = createBinaryTree(preorder,inorder,inorderIndex+1,inEnd);
        return root;
    }
}
