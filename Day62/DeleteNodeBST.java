package Day62;

public class DeleteNodeBST {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(5);
        root.left = new TreeNodeOne(3);
        root.right = new TreeNodeOne(6);
        root.left.left = new TreeNodeOne(2);
        root.left.right = new TreeNodeOne(4);
        root.right.right = new TreeNodeOne(7);
        int key = 3;

        DeleteNodeBST solution = new DeleteNodeBST();
        TreeNodeOne result = solution.deleteNode(root, key);
        System.out.println("After deleting " + key + ":");
        printTree(result);
    }

    private static void printTree(TreeNodeOne node) {
        if (node == null)
            return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }

    public TreeNodeOne deleteNode(TreeNodeOne root, int key) {
        if (root == null)
            return null;

        if (root.val == key && (root.right == null && root.left == null)) {
            root = null;
            return root;
        }

        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;
            else {
                root.val = minHelper(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    public int minHelper(TreeNodeOne root)
    {
        int min = root.val;
        if (root == null)
            return min;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
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
