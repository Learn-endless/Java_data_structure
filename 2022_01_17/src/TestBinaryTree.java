import javax.transaction.TransactionRequiredException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-17
 * Time: 16:58
 */
public class TestBinaryTree {
    public static void main1(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode tree = binaryTree.createBinaryTree();
        //前序遍历
        binaryTree.preOrder(tree);
        System.out.println();
        //中序遍历
        binaryTree.inOrder(tree);
        System.out.println();
        //后序遍历
        binaryTree.postOrder(tree);
        System.out.println();
    }
}
