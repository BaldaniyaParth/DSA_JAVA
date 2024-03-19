package Day51;

public class MaximumDepthBinaryTree {

    public static void main(String[] args) {

        TreeNodeOne root = new TreeNodeOne(3);
        root.left = new TreeNodeOne(9);
        root.right = new TreeNodeOne(20);
        root.right.left = new TreeNodeOne(15);
        root.right.right = new TreeNodeOne(7);

        MaximumDepthBinaryTree solution = new MaximumDepthBinaryTree();

        int result = solution.maxDepth(root);
        System.out.println("Maximum Depth: " + result);
    }
    public int maxDepth(TreeNodeOne root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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