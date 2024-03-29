package Day60;
import java.util.*;

public class FlattenBinaryTreeLinkedList {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(1);
        root.left = new TreeNodeOne(2);
        root.right = new TreeNodeOne(5);
        root.left.left = new TreeNodeOne(3);
        root.left.right = new TreeNodeOne(4);
        root.right.right = new TreeNodeOne(6);

        // Flatten the tree
        FlattenBinaryTreeLinkedList solution = new FlattenBinaryTreeLinkedList();
        solution.flatten(root);

        // Print the flattened tree
        System.out.print("Flattened tree: ");
        printFlattenedTree(root);
    }

    public void flatten(TreeNodeOne  root) {
        TreeNodeOne  curr = root;
        while (curr != null) {
            // if left part exists then
            if (curr.left != null) {
                // find predecessor
                TreeNodeOne  pred = curr.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                // create a link between pred and curr's right
                pred.right = curr.right;
                // now make curr's right to curr's left and go to next iteration
                curr.right = curr.left;
                curr.left = null; // Set left to null
            }
            // if not exist then move the current by right
            curr = curr.right;
        }
    }

    public static void printFlattenedTree(TreeNodeOne  root) {
        TreeNodeOne  current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
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