import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 21:04
 */

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    //二叉树的层序遍历方法一：使用List<List<Integer>>返回
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        //用来存放整个二叉树
        List<List<Integer>> total = new ArrayList<>();
        //创建一个队列用来过渡使用
        Queue<TreeNode> qu = new LinkedList<>();
        //二叉树如果为null，放回空
        if(root == null){
            return total;
        }
        //将第一节点添加到队列中
        qu.offer(root);
        //看看队列里是不是空的
        while(!qu.isEmpty()){
            //求一下当前队列里的元素个数，决定这一层有多少节点
            int size = qu.size();
            //临时用来存放每一层节点的值
            List<Integer> list = new ArrayList<>();
            //循环拿到每层节点的值
            while(size-- != 0){
                //弹出队列头的值
                TreeNode cur = qu.poll();
                //添加到临时存放点
                list.add(cur.val);
                //如果有左右子数，将它们都添加到队列中去
                if(cur.left != null){
                    qu.offer(cur.left);
                }
                if(cur.right != null) {
                    qu.offer(cur.right);
                }
            }
            //将每层的数据添加到总的内存中
            total.add(list);
        }
        //返回总的数据
        return total;
    }

    //二叉树的方法二：直接遍历打印结果
    public static void levelOrder2(TreeNode root){
        Queue<TreeNode> qu = new LinkedList<>();
        //先判断是否为null
        if(root == null){
            return;
        }
        //添加根节点
        qu.offer(root);
        //循环遍历队列中的元素
        while(!qu.isEmpty()){
            //出队一个元素
            TreeNode cur = qu.poll();
            //打印数值
            System.out.print(cur.val+" ");
            //看看这个节点的左子树与右子树是不是为null
            if(cur.left != null){
                //不为null，将它们都添加到队列中去
                qu.offer(cur.left);
            }
            if(cur.right != null){
                qu.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        MyBinaryTree m = new MyBinaryTree();
        TreeNode root = m.createBinaryTree();
        levelOrder2(root);
        System.out.println();
        List<List<Integer>> lists = levelOrder1(root);
        for (List<Integer> list:lists) {
            System.out.print(list+" ");
        }
    }
}
