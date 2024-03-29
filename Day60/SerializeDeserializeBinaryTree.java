package Day60;
import java.util.*;

public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();

        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        TreeNode deserializedRoot = codec.deserialize(serialized);

        System.out.print("Inorder traversal of the deserialized tree: ");
        inorderTraversal(deserializedRoot);
    }

    private static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializer(root, sb);
        return sb.toString();
    }

    void serializer(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n ");
            return;
        }
        sb.append(root.val).append(" ");
        serializer(root.left, sb);
        serializer(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        final String[] vals = data.split(" ");
        Queue<String> q = new ArrayDeque<>(Arrays.asList(vals));
        return deserializer(q);
    }

    TreeNode deserializer(Queue<String> q) {
        final String s = q.poll();
        if (s.equals("n")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializer(q);
        root.right = deserializer(q);
        return root;
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