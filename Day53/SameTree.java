package Day53;

public class SameTree {

    public static void main(String[] args) {
        TreeNodeOne p = new TreeNodeOne(1);
        p.left = new TreeNodeOne(2);
        p.right = new TreeNodeOne(3);

        TreeNodeOne q = new TreeNodeOne(1);
        q.left = new TreeNodeOne(2);
        q.right = new TreeNodeOne(3);

        SameTree solution = new SameTree();

        boolean result = solution.isSameTree(p, q);
        System.out.println("Are the trees the same? " + result);
    }

    public boolean isSameTree(TreeNodeOne p, TreeNodeOne q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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