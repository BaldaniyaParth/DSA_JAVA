package Day50;
import java.util.ArrayList;
import java.util.List;
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNodeTwo root = new TreeNodeTwo(1);
        root.right = new TreeNodeTwo(2);
        root.right.left = new TreeNodeTwo(3);

        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();

        List<Integer> result = solution.postorderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
    }

    static List<Integer> list = new ArrayList<Integer>();

    public static List<Integer> postorderTraversal(TreeNodeTwo root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }

        return list;

    }
}

class TreeNodeTwo {
    int val;
    TreeNodeTwo left;
    TreeNodeTwo right;

    TreeNodeTwo() {}

    TreeNodeTwo(int val) {
        this.val = val;
    }

    TreeNodeTwo(int val, TreeNodeTwo left, TreeNodeTwo right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}