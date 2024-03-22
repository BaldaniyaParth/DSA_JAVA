package Day54;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Creating an instance of Solution class
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();

        // Performing zigzag level order traversal and printing the result
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println("Zigzag Level Order Traversal: " + result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> v = new ArrayList<>();
        boolean leftToRight = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp != null) {
                v.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            } else {
                if (leftToRight) {
                    ans.add(new ArrayList<>(v));
                } else {
                    reverseList(v);
                    ans.add(new ArrayList<>(v));
                }
                v.clear();
                leftToRight = !leftToRight;
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        return ans;
    }

    private void reverseList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
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
