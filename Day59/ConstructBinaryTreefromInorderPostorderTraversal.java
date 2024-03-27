package Day59;
import java.util.*;

public class ConstructBinaryTreefromInorderPostorderTraversal {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        ConstructBinaryTreefromInorderPostorderTraversal solution = new ConstructBinaryTreefromInorderPostorderTraversal();

        TreeNode root = solution.buildTree(inorder, postorder);

        System.out.print("Inorder traversal of the constructed tree: ");
        solution.inorderTraversal(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,
                                     int ps, int pe, HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftChild = buildTreePostIn(inorder, is, ri - 1, postorder, ps,
                ps + ri - is - 1, hm);
        TreeNode rightChild = buildTreePostIn(inorder, ri + 1, ie, postorder,
                ps + ri - is, pe - 1, hm);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    // Helper method to print inorder traversal of the tree
    private void inorderTraversal(TreeNode root) {
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
