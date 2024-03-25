package Day57;
import java.util.*;

public class MaximumWidthBinaryTree {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(1);
        root.left = new TreeNodeOne(3);
        root.right = new TreeNodeOne(2);
        root.left.left = new TreeNodeOne(5);
        root.left.right = new TreeNodeOne(3);
        root.right.right = new TreeNodeOne(9);

        MaximumWidthBinaryTree solution = new MaximumWidthBinaryTree();

        int width = solution.widthOfBinaryTree(root);
        System.out.println("Width of the binary tree: " + width);
    }

    public static int widthOfBinaryTree(TreeNodeOne root) {
        if (root == null) return 0;
        return width(root, 0, 1, new ArrayList<>());
    }

    public static int width(TreeNodeOne root, int depth, int index, List<Integer> list) {
        if (root == null) return 0;
        if (depth == list.size()) list.add(index);
        int currentWidth = index - list.get(depth) + 1;
        int leftWidth = width(root.left, depth + 1, index * 2, list);
        int rightWidth = width(root.right, depth + 1, index * 2 + 1, list);
        return Math.max(currentWidth, Math.max(leftWidth, rightWidth));
    }
}

class TreeNodeOne {
    int val;
    TreeNodeOne left;
    TreeNodeOne right;

    TreeNodeOne(int val) {
        this.val = val;
    }
}
