package Day62;
import java.util.*;
public class KthSmallestElementBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;

        KthSmallestElementBST solution = new KthSmallestElementBST();
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        solution(root, list);
        return list.get(k - 1);
    }

    private void solution(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        solution(root.left, list);
        list.add(root.val);
        solution(root.right, list);
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