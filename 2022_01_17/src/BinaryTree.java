import java.util.LinkedList;
import java.util.Queue;

//节点实体类
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char val){
        this.val = val;
    }
}
//这是一个二叉树实体类
public class BinaryTree {
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

    //前序遍历
    public void preOrder(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    //遍历思路，求出二叉树的总节点数
    public int size1(TreeNode root){
        int count = 0;
        if(root == null){
            return count;
        }
        count++;
        count += size1(root.left);
        count += size1(root.right);
        return count;
    }
    //子问题思路求出二叉树的总节点数
    public int size2(TreeNode root){
        int count = 0;
        if(root == null){
            return count;
        }
        count = size1(root.left)+size1(root.right)+1;
        return count;
    }

    //求叶子节点的个数
    public int getLeafNodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodeCount(root.left)+getLeafNodeCount(root.right);
    }

    //求第k层的节点个数
    public int getKLevelNodeCount(TreeNode root, int k){
        if(root == null || k < 1){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+ getKLevelNodeCount(root.right,k-1);
    }
    //求二叉树的高度
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
    //找到是否有value这个值
    public TreeNode find(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode left = find(root.left,val);
        if(left != null){
            return left;
        }else {
            return find(root.right,val);
        }
    }
    //检查当前二叉树是否都是null
    private boolean check(Queue<TreeNode> queue){
        while(!queue.isEmpty()){
            TreeNode ret = queue.poll();
            if(ret != null){
                return false;
            }
        }
        return true;
    }

    //判断是否是一个完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode ret = queue.poll();
            if(ret != null){
                queue.offer(ret.left);
                queue.offer(ret.right);
            }else{
                break;
            }
        }
        return check(queue);
    }
}
