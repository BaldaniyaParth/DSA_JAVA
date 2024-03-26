package Day58;
import java.util.*;
public class AllNodesDistanceKBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left;

        int k = 2;

        AllNodesDistanceKBinaryTree solution = new AllNodesDistanceKBinaryTree();

        List<Integer> result = solution.distanceK(root, target, k);
        System.out.println("Nodes at distance " + k + " from node " + target.val + ": " + result);
    }

    List<Integer> ans;
    boolean bool;
    int tar;
    int dist;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        bool = false;
        tar = target.val;
        dist = k;
        if (root == null) return ans;
        helper(root, 1);
        return ans;
    }

    public int helper(TreeNode root, int h) {
        if (root == null) return h - 1;
        if (root.val == tar) {
            add(root, 0);
            bool = true;
            return 0;
        }
        if (bool && h == dist) {
            ans.add(root.val);
        }
        int left = helper(root.left, h + 1);
        if (bool) {
            h = left + 1;
            if (bool && h == dist) {
                ans.add(root.val);
            }
            add(root.right, h + 1);
            return h;
        }
        int right = helper(root.right, h + 1);
        if (bool) {
            h = right + 1;
            if (bool && h == dist) {
                ans.add(root.val);
            }
            add(root.left, h + 1);
            return h;
        }
        return h;
    }

    public void add(TreeNode root, int h) {
        if (root == null) return;
        if (h == dist) {
            ans.add(root.val);
        }
        add(root.left, h + 1);
        add(root.right, h + 1);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}