/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-11
 * Time: 17:17
 */
public class Tree2str {
    /*
    606. 根据二叉树创建字符串
    你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     */
    public String tree2str(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuilder s = new StringBuilder();
        treeStringBuilder(root, s);
        return s.toString();
    }

    //自定义方法，将二叉树转换为字符串(采用前序遍历)
    private void treeStringBuilder(TreeNode root, StringBuilder s){
        if(root == null){
            return;
        }
        //将根节点添加到字符串中
        s.append(root.val);
        //判断根节点的左子树是不是空树
        if(root.left != null){
            //不是就继续递归
            s.append("(");
            treeStringBuilder(root.left, s);
            s.append(")");
        }else{
            //左子树为空树时，判断右子树是否为空树
            if(root.right == null){
                //右子树也为空树，说明该树添加完成
                return;
            }else{
                //满足左子树为空，右子树不为空树，先添加一个()
                s.append("()");
            }
        }
        //对右子树进行递归处理
        if(root.right != null){
            s.append("(");
            treeStringBuilder(root.right, s);
            s.append(")");
        }
    }
}
