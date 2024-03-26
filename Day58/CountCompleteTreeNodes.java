package Day58;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(1);
        root.left = new TreeNodeOne(2);
        root.right = new TreeNodeOne(3);
        root.left.left = new TreeNodeOne(4);
        root.left.right = new TreeNodeOne(5);
        root.right.left = new TreeNodeOne(6);

        // Creating an instance of Solution class
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();

        // Counting the number of nodes in the binary tree and printing the result
        int count = solution.countNodes(root);
        System.out.println("Number of nodes in the binary tree: " + count);
    }

    public int countNodes(TreeNodeOne root) {
        if (root == null) {   // Check if root is equal to null simply return 0.
            return 0;
        } else if (root.right == null) {   // If root's right side is null go to the left side and count nodes & Increse 1 for current node.
            return countNodes(root.left) + 1;
        } else if (root.left == null) {   // If root's left side is null go to the right side and count nodes & Increse 1 for current node.
            return countNodes(root.right) + 1;
        } else {   // If root's both sides have a node go to both sides of root node and count nodes & Increse 1 for the current node.
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
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
