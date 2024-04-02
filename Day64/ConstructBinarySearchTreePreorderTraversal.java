package Day64;

public class ConstructBinarySearchTreePreorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        ConstructBinarySearchTreePreorderTraversal solution = new ConstructBinarySearchTreePreorderTraversal();
        TreeNode root = solution.bstFromPreorder(preorder);

        System.out.println("BST constructed from preorder traversal:");
        printTree(root);
    }

    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);

        return root;
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