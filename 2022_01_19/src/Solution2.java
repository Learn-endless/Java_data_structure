import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-19
 * Time: 10:49
 */
public class Solution2 {
    public void levelOrder1(TreeNode root) {
        if(root == null){
            return;
        }
        qu.offer(root);
        while(!qu.isEmpty()){
            TreeNode cur = qu.poll();
            System.out.print(cur.val+" ");
            if(cur.left != null){
                qu.offer(cur.left);
            }
            if(cur.right != null) {
                qu.offer(cur.right);
            }
        }
    }

    Queue<TreeNode> qu = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> total = new ArrayList<>();

        if(root == null){
            return total;
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(root.val);
        total.add(list1);
        qu.offer(root);
        while(!qu.isEmpty()){
            TreeNode cur = qu.poll();
            List<Integer> list = new ArrayList<>();
            list.add(cur.val);
            if(root.left != null){
                qu.offer(root.left);
            }else if(root.right != null) {
                qu.offer(root.right);
            }
            total.add(list);
        }
        return total;
    }
}
