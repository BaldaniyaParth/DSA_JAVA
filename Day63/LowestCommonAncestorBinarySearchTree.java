package Day63;

public class LowestCommonAncestorBinarySearchTree {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(6);
        root.left = new TreeNodeOne(2);
        root.right = new TreeNodeOne(8);
        root.left.left = new TreeNodeOne(0);
        root.left.right = new TreeNodeOne(4);
        root.right.left = new TreeNodeOne(7);
        root.right.right = new TreeNodeOne(9);
        root.left.right.left = new TreeNodeOne(3);
        root.left.right.right = new TreeNodeOne(5);

        TreeNodeOne p = root.left;
        TreeNodeOne q = root.right;

        LowestCommonAncestorBinarySearchTree solution = new LowestCommonAncestorBinarySearchTree();
        TreeNodeOne lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + ": " + lca.val);
    }

    public TreeNodeOne lowestCommonAncestor(TreeNodeOne root, TreeNodeOne p, TreeNodeOne q) {
        while (root != null) {
            if ((root == p || root == q) || (root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val))
                return root;
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
        }
        return root;
    }

}

class TreeNodeOne {
    int val;
    TreeNodeOne left;
    TreeNodeOne right;

    TreeNodeOne(int x) {
        val = x;
    }
}

