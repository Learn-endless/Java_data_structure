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
}
