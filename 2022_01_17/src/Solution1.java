import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-17
 * Time: 17:08
 */
public class Solution1 {
    //144. 二叉树的前序遍历(LeetCode)
    public List<Integer> preorderTraversal(TreeNode root) {
        //每次调用都创建一个List集合
        List<Integer> list = new ArrayList<>();
        if(root == null){
            //如果为空，就返回一个空集合
            return list;
        }
        //不为空，先将根节点的值添加到list集合中
        list.add(root.val);
        //统计该节点的左孩子节点
        List<Integer> left = preorderTraversal(root.left);
        //统计该节点的右孩子节点
        List<Integer> right = preorderTraversal(root.right);
        //将统计的节点数添加到集合中，并返回
        list.addAll(left);
        list.addAll(right);
        return list;
    }
}
