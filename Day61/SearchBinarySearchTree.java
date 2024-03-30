package Day61;

public class SearchBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Value to search
        int val = 2;

        // Search for the value in the BST
        SearchBinarySearchTree solution = new SearchBinarySearchTree();
        TreeNode resultNode = solution.searchBST(root, val);

        // Print the result
        if (resultNode != null) {
            System.out.println("Node with value " + val + " found in the BST.");
        } else {
            System.out.println("Node with value " + val + " not found in the BST.");
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // Helper method to print inorder traversal of the binary tree
    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
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
