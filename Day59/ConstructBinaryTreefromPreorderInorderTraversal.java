package Day59;
import java.util.*;
public class ConstructBinaryTreefromPreorderInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBinaryTreefromPreorderInorderTraversal solution = new ConstructBinaryTreefromPreorderInorderTraversal();

        TreeNodeOne root = solution.buildTree(preorder, inorder);

        System.out.print("Inorder traversal of the constructed tree: ");
        solution.inorderTraversal(root);
    }

    public TreeNodeOne buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNodeOne root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    static TreeNodeOne buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNodeOne root = new TreeNodeOne(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

    // Helper method to print inorder traversal of the tree
    private void inorderTraversal(TreeNodeOne root) {
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