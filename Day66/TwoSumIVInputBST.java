package Day66;
import java.util.ArrayList;
public class TwoSumIVInputBST {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(5);
        root.left = new TreeNodeOne(3);
        root.right = new TreeNodeOne(6);
        root.left.left = new TreeNodeOne(2);
        root.left.right = new TreeNodeOne(4);
        root.right.right = new TreeNodeOne(7);
        int k = 9;

        Solution1 solution = new Solution1();
        boolean targetFound = solution.findTarget(root, k);
        System.out.println("Is there a pair of nodes in the tree whose sum equals " + k + "? " + targetFound);
    }


}

class Solution1 {
    ArrayList<Integer> al = new ArrayList<>();

    public void inorder(TreeNodeOne root) {
        if (root == null)
            return;

        inorder(root.left);
        al.add(root.val);
        inorder(root.right);
    }

    public boolean findTarget(TreeNodeOne root, int k) {
        inorder(root);

        int n = al.size();

        int i = 0;
        int j = n - 1;

        while (i < j) {
            int sum = al.get(i) + al.get(j);

            if (sum == k)
                return true;
            else if (sum < k)
                i++;
            else if (sum > k)
                j--;
        }

        return false;
    }
}

class TreeNodeOne {
    int val;
    TreeNodeOne left;
    TreeNodeOne right;

    TreeNodeOne() {}

    TreeNodeOne(int val) {
        this.val = val;
    }

    TreeNodeOne(int val, TreeNodeOne left, TreeNodeOne right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
