package Day52;

public class DiameterBinaryTree {

    public static void main(String[] args) {

        TreeNodeOne root = new TreeNodeOne(1);
        root.left = new TreeNodeOne(2);
        root.right = new TreeNodeOne(3);
        root.left.left = new TreeNodeOne(4);
        root.left.right = new TreeNodeOne(5);

        DiameterBinaryTree solution = new DiameterBinaryTree();

        int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result);
    }

    public static int diameterOfBinaryTree(TreeNodeOne root) {
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }

    private static int height(TreeNodeOne root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left, ans);
        int right = height(root.right, ans);

        ans[0] = Math.max(left + right, ans[0]);

        return Math.max(left, right) + 1;
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
