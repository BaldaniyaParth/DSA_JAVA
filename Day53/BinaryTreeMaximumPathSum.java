package Day53;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

        int result = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }

    private static int max;

    public static int helper(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = Math.max(0, helper(node.left));
        int rightSum = Math.max(0, helper(node.right));

        max = Math.max(max, leftSum + rightSum + node.val);

        return Math.max(leftSum, rightSum) + node.val;
    }

    public static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}