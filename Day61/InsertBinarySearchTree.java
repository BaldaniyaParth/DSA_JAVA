package Day61;

public class InsertBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Value to insert
        int val = 5;

        // Insert val into the BST
        InsertBinarySearchTree solution = new InsertBinarySearchTree();
        TreeNode modifiedRoot = solution.insertIntoBST(root, val);

        // Print the inorder traversal of the modified BST
        System.out.print("Inorder traversal of the modified BST: ");
        inorderTraversal(modifiedRoot);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // Helper method to print inorder traversal of the binary tree
    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}