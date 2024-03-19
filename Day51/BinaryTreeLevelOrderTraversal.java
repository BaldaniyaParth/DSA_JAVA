package Day51;
import java.util.*;
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println("Level Order Traversal: " + result);
    }
    static List<List<Integer>> ans;

    static void solve(TreeNode root, int lvl) {
        if(root == null) return;
        if(ans.size() == lvl) {
            ans.add(new ArrayList<>());
        }
        ans.get(lvl).add(root.val);
        solve(root.left, lvl + 1);
        solve(root.right, lvl + 1);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, 0);
        return ans;
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