package Day65;
import java.util.*;
public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator obj = new BSTIterator(root);

        List<Object> output = new ArrayList<>();
        output.add(null);
        output.add(obj.next());
        output.add(obj.next());
        output.add(obj.hasNext());
        output.add(obj.next());
        output.add(obj.hasNext());
        output.add(obj.next());
        output.add(obj.hasNext());
        output.add(obj.next());
        output.add(obj.hasNext());

        System.out.println("Output: " + output);
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

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        for (var a = root; a != null; a = a.left)
            stack.push(a);
    }

    public int next() {
        var node = stack.pop();

        for (var a = node.right; a != null; a = a.left)
            stack.push(a);

        return node.val;
    }

    public boolean hasNext() {
        return !stack.empty();
    }
}
