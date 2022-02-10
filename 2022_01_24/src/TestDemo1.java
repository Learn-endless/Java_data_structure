import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-24
 * Time: 10:20
 */
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
}

/**
 * leetcode题目：
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）”
 */
public class TestDemo1 {
    /*
    方法一：假设给予的是一颗二叉搜索树
    步骤：
    1.判断该节点是不是null
    2.判断该节点是不是p或者q
    3.分别递归处理该树的左子树与右子树
    4.通过返回值判断情况：
        q和p分别在左右子树中
        q和p都在左子树中
        q和p都在右子树中
        左右子树中都找不到q和p
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        //递归处理左子树与右子树的情况。
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        //通过返回值判断是否在左子树与右子树中找到p和q
        if(left != null && right != null){
            return root;
        }else if(left == null){
            return right;
        }else{
            return left;
        }
    }

    /*
    方法二，通过链表求交点的思路求解
    步骤：
    1.找到根节点到指定节点的路径
    2.将两条路径分别放到两个栈中
    3.先将元素多的栈出两个栈的差值个元素
    4.一组一组的出栈，并拿出栈元素相比较，相同找到了最小公共祖先
    5.找不到，说明没有公共祖先
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //root为空，就不用找公共祖先了
        if(root == null){
            return null;
        }
        //创建两个栈，用来存放p和q的路径
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root,p,stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root,q,stack2);

        //将元素较多的栈中，先弹出差值个元素。
        int size1 = stack1.size();
        int size2 = stack2.size();

        //栈1的元素多于栈2时的情况
        if(size1 > size2){
            int size = size1-size2;
            //弹差值个元素
            while(size != 0){
                stack1.pop();
                size--;
            }
            //然后从两个栈中一组一组的弹出元素，并判断弹出的元素是不是同一个节点
            while(!stack1.isEmpty()&&!stack2.isEmpty()){
                if(stack1.peek() == stack2.peek()){
                    //是同一个节点，就说明找到了最小公共祖先
                    return stack1.pop();
                }
                //一组一组的弹出元素
                stack1.pop();
                stack2.pop();
            }
        }else{
            //栈2多于栈1时的情况
            //与上相同的操作
            int size = size2-size1;
            while(size != 0){
                stack2.pop();
                size--;
            }
            while(!stack1.isEmpty()&&!stack2.isEmpty()){
                if(stack1.peek() == stack2.peek()){
                    return stack1.pop();
                }
                stack1.pop();
                stack2.pop();
            }
        }
        //走到这里说明找不到相同的节点，也就是没有公共祖先
        return null;
    }

    //获取根节点到指定节点的路径
    private boolean getPath(TreeNode root, TreeNode flg, Stack<TreeNode> stack){
        //有一个为空，不用获取，直接返回false
        if(root == null || flg == null){
            return false;
        }
        //先添加到栈中
        stack.push(root);
        //判断当前节点是不是指定节点
        if(root == flg){
            return true;
        }
        //递归处理左子树
        boolean ret = getPath(root.left, flg, stack);
        //通过返回值来判断在左子树中找到指定节点没
        if(ret){
            return true;
        }
        //相同方法处理右子树
        ret = getPath(root.right, flg, stack);
        if(ret){
            return true;
        }
        //走到这里说明当前节点的左子树与右子树中都没有指定节点
        //同时该节点也不是路径上的节点，出栈
        stack.pop();
        //返回false
        return false;
    }
}
