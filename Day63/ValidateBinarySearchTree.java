package Day63;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        boolean isValid = solution.isValidBST(root);
        System.out.println("Is valid BST? " + isValid);
    }

    TreeNode prev = null;
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && root.val <= prev.val) result = false;
        prev = root; // Update prev to current node before going to the right subtree
        helper(root.right);
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
