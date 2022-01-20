import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 21:42
 */

/**
 * 958. 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * （注：第 h 层可能包含 1~2h个节点。）
 */
public class IsCompleteTree {
    //用来检查当前队列中是不是只有null元素
    public boolean checkQueue(Queue<TreeNode> qu){
        while(!qu.isEmpty()){
            TreeNode cur = qu.poll();
            if(cur != null){
                //有一个元素不是null，返回false
                return false;
            }
        }
        return true;
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        if(root == null){
            return true;
        }
        //将跟节点添加到队列中
        qu.offer(root);
        //遍历队列
        while(!qu.isEmpty()){
            //出队一个元素
            TreeNode cur = qu.poll();
            //如果对头元素为空，结束循环，判断队列中的情况
            if(cur == null){
                break;
            }else{
                //弹出的元素不为null时，继续添加（注意这里需要把null也添加进去）
                qu.offer(cur.left);
                qu.offer(cur.right);
            }
        }
        //检查队列中情况
        return checkQueue(qu);
    }
}
