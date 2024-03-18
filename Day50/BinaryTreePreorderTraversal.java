package Day50;
import java.util.*;
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(1);
        root.right = new TreeNodeOne(2);
        root.right.left = new TreeNodeOne(3);

        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();

        List<Integer> result = solution.preorderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
    }

    static List<Integer> list = new ArrayList<Integer>();

    public static List<Integer> preorderTraversal(TreeNodeOne root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }


}

class TreeNodeOne {
    int val;
    TreeNodeOne left;
    TreeNodeOne right;

    TreeNodeOne() {}

    TreeNodeOne(int val) {
        this.val = val;
    }

    TreeNodeOne(int val, TreeNodeOne left, TreeNodeOne right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
