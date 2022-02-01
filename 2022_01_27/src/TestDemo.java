import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-27
 * Time: 23:42
 */
 /**
 *这是一个二叉树的节点类
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }

/**
 * 144. 二叉树的前序遍历
 * 使用非递归完成二叉树的前序遍历
 */
public class TestDemo {
    //定义一个方法，前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        //通过栈来完成
        Stack<TreeNode> stack = new Stack<>();
        //将遍历好的数据用List集合来存储
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        //循环
        while (cur != null || !stack.isEmpty()) {
            //一直往左子树走，走到空跳出循环
            while (cur != null) {
                //每找到一颗子树的跟节点，就存放到集合中
                list.add(cur.val);
                //同时将该节点放到栈中
                stack.push(cur);
                //往左走
                cur = cur.left;
            }
            //左边为空了，通过弹出栈顶元素往右边走
            TreeNode top = stack.pop();
            cur = top.right;
        }
        //最后返回数据
        return list;
    }
	
	//二叉树数中序遍历，非递归完成
    public List<Integer> inorderTraversal(TreeNode root) {
        //通过栈来完成
        Stack<TreeNode> stack = new Stack<>();
        //将遍历好的数据用List集合来存储
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        //循环
        while (cur != null || !stack.isEmpty()) {
            //一直往左子树走，走到空跳出循环
            while (cur != null) {
                //将该节点放到栈中
                stack.push(cur);
                //往左走
                cur = cur.left;
            }
            //左边为空了，通过弹出栈顶元素往右边走
            TreeNode top = stack.pop();
		    //找到一个就放到集合中
            list.add(top.val);
            cur = top.right;
        }
        //最后返回数据
        return list;
    }
	
	//二叉树后序遍历，非递归完成
	public List<Integer> postorderTraversal(TreeNode root) {
        //使用一个List集合来存放后序遍历
        List<Integer> list = new ArrayList<>();
        //通过栈来进行处理
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //记录上一次处理的节点
        TreeNode flg = null;
        //当前节点不为空或者栈不为空时进行循环
        while(cur != null || !stack.isEmpty()){
            //一直往左走，走到空为止
            while(cur != null){
                //找到一个就放到栈中
                stack.push(cur);
                cur = cur.left;
            }
            //查看一下当前栈顶节点
            TreeNode top = stack.peek();
            //如果当前栈顶节点的右子树是null或者右子树已经在上一次进行处理过了
            //就进入if语句，进行处理当前节点
            if(top.right == null || top.right == flg){
                //将val的值放到List集合中
                list.add(top.val);
                //标记一下处理的节点
                flg = top;
                //出栈
                stack.pop();
            }else{
                //往右子树走
                cur = top.right;
            }
        }
        return list;
    }
}
