/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-24
 * Time: 19:36
 */

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node(int val){
        this.val = val;
    }
}

/**
 * 二叉搜索树（有序数）
 * 根节点 比 左子树 都大 ， 比 右子树 都小，并且每颗子树都是如此。
 */
public class BinarySearchTree {
    public Node root = null;

    /**
     * 在二叉搜索树中查找某个节点
     * @param key 要查找的节点
     * @return 返回该节点的地址
     */
    public Node search(int key){
        if(root == null){
            return null;
        }
        Node cur = root;
        while(cur != null){
            if(cur.val == key){
                return cur;
            }else if(cur.val > key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * 在二叉搜索树中插入一个节点
     * 注意：如果插入的 值 等于该树中某一个节点，那么插入失败
     * @param key  插入的数据
     * @return     提示是否插入成功
     */
    public boolean insert(int key){
        if(root == null){
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node prev = null;
        while(cur != null){
            if(cur.val == key){
                return false;
            }else if(cur.val > key){
                prev = cur;
                cur = cur.left;
            }else{
                prev = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(key);
        if(prev.val > key){
            prev.left = node;
        }else{
            prev.right = node;
        }
        return true;
    }

    /**
     * 在二叉搜索树中删除某个节点
     * @param key 删除节点的 val 值
     */
    public void remove(int key){
        //先判空
        if(root == null){
            return;
        }
        //先遍历找到该节点
        Node cur = root;
        // parent 用来记录 key 的 父亲节点
        Node parent = null;
        while(cur != null){
            if(cur.val == key){
                //找到后，专门用一个方法来删除该节点
                removeKey(cur,parent);
                break;
            //key比当前节点的 val 值小，就往 左子树 找
            }else if(cur.val > key){
                parent = cur;    // 记录 cur 的 父亲节点
                cur = cur.left;
            //key比当前节点的 val 值大，就往 右子树 找
            }else{
                parent = cur;   // 记录 cur 的 父亲节点
                cur = cur.right;
            }
        }
    }

    /**
     * 真正删除节点的方法
     * @param cur     需要删除的节点
     * @param parent  删除节点的父亲节点
     */
    private void removeKey(Node cur,Node parent){
        //当需要删除节点的 左子树 为 空时
        if(cur.left == null){
            //如果删除的节点为 根节点 时
            if(cur == root){
                root = cur.right;
            //不为 根节点 ，并且是它父亲节点的 右子树 时
            }else if(cur == parent.right){
                parent.right = cur.right;
            //不为 根节点 ，并且是它父亲节点的 左子树 时
            }else{
                parent.left = cur.right;
            }
        //当需要删除节点的 右子树 为 空时
        }else if(cur.right == null){
            //如果删除的节点为 根节点 时
            if(cur == root){
                root = cur.left;
            //不为 根节点 ，并且是它父亲节点的 右子树 时
            }else if(cur == parent.right){
                parent.right = cur.left;
            //不为 根节点 ，并且是它父亲节点的 左子树 时
            }else{
                parent.left = cur.left;
            }
        //如果需要删除的节点的两边都不为 null 时的情况
        }else{
            /*
            两种思路：
            1. 先找到需要删除节点的右子树中 val 值最小的那个节点，然后将它的 val 值覆盖到需要删除的节点上 ，最后删掉那个节点
            2. 先找到需要删除节点的左子树中 val 值最大的那个节点，然后将它的 val 值覆盖到需要删除的节点上 ，最后删掉那个节点

            这里使用第一种思路，先找到右子树中最小的节点
            由于在删除子节点时，我们需要知道该节点的 父亲 节点，所以 用 prevTmp 来记录 tmp 的父亲节点
            */
            Node prevTmp = cur;
            Node tmp = cur.right;
            //循环一直往左走
            while(tmp.left != null){
                prevTmp = tmp;
                tmp = tmp.left;
            }
            //找到后，直接覆盖到 需要删除 的节点上
            cur.val = tmp.val;
            //通过判断 删除的节点是 prevTmp 的 左子树 或者 右子树，来删除这个节点
            if(tmp == prevTmp.left){
                prevTmp.left = tmp.right;
            }else{
                prevTmp.right = tmp.right;
            }
        }
    }

    /**
     * 中序遍历
     * @param root 根节点
     */
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] data = {10,5,8,7,9,6,12,1,2};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int x:data) {
            binarySearchTree.insert(x);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println("\n插入重复的数据");
        System.out.println(binarySearchTree.insert(2));
        System.out.println("删除某个节点");
        binarySearchTree.remove(12);
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println("\n查询某个节点");
        Node node = binarySearchTree.search(10);
        System.out.println(node.val);

    }
}
