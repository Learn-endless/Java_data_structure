/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-20
 * Time: 19:20
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        TreeNode root = myBinaryTree.createBinaryTree();
        System.out.println(myBinaryTree.totalTreeNode(root));
        System.out.println(myBinaryTree.totalLeafTreeNode(root));
        System.out.println(myBinaryTree.totalLayerTreeNode(root, 4));
        TreeNode ret = myBinaryTree.findValue(root,'G');
        System.out.println((char)ret.val);
    }
}
