import javax.transaction.TransactionRequiredException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-01-17
 * Time: 16:58
 */
public class TestBinaryTree {
    public static void main(String[] args) {
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
//        System.out.println();
//        System.out.println(binaryTree.size1(tree));
//        System.out.println(binaryTree.size2(tree));
//        System.out.println(binaryTree.getLeafNodeCount(tree));
//        System.out.println(binaryTree.getKLevelNodeCount(tree,3));
//        System.out.println(binaryTree.getHeight(tree));
        System.out.println();
//        TreeNode ret = binaryTree.find(tree,'B');
//        System.out.println(ret.val);
        System.out.println(binaryTree.isCompleteTree(tree));
    }
}
