import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 21:01
 */

/**
 *KY11 二叉树遍历
 * 描述
 * 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
 * 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
 * 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 * 输入描述：
 * 输入包括1行字符串，长度不超过100。
 * 输出描述：
 * 可能有多组测试数据，对于每组数据， 输出将输入字符串建立二叉树后中序遍历的序列，每个字符后面都有一个空格。 每个输出结果占一行。
 */
public class CreateBinaryTree {
    //用来遍历字符串
    public static int i = 0;
    //使用先序遍历字符串创建二叉树
    public static TreeNode inorder(String str){
        if(str == null){
            return null;
        }
        //先判断是否为#
        if(str.charAt(i) != '#'){
            //不是，可以创建节点了
            TreeNode node = new TreeNode(str.charAt(i));
            i++;
            node.left = inorder(str);
            node.right = inorder(str);
            return node;
        }else{
            //不是i往后走
            i++;
            return null;
        }
    }

    //对二叉树进行中序遍历打印结果
    public static void myPrint(TreeNode root){
        if(root == null){
            return;
        }
        //先左子树
        myPrint(root.left);
        //打印根节点
        System.out.print(root.val+" ");
        //然后右子树
        myPrint(root.right);
    }
    //主方法，多组输入
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            TreeNode node = inorder(str);
            myPrint(node);
        }
    }
}
