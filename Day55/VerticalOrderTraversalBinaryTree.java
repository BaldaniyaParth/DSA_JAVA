package Day55;
import java.util.*;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalOrderTraversalBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        VerticalOrderTraversalBinaryTree solution = new VerticalOrderTraversalBinaryTree();

        List<List<Integer>> result = solution.verticalTraversal(root);
        System.out.println("Vertical Traversal: " + result);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, new Pair<>(0, 0)));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> pair = queue.poll();
            TreeNode node = pair.first;
            int x = pair.second.first;
            int y = pair.second.second;

            if (!nodes.containsKey(x)) {
                nodes.put(x, new TreeMap<>());
            }
            if (!nodes.get(x).containsKey(y)) {
                nodes.get(x).put(y, new PriorityQueue<>());
            }
            nodes.get(x).get(y).offer(node.val);

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, new Pair<>(x - 1, y + 1)));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, new Pair<>(x + 1, y + 1)));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> column : nodes.values()) {
            List<Integer> colValues = new ArrayList<>();
            for (PriorityQueue<Integer> row : column.values()) {
                while (!row.isEmpty()) {
                    colValues.add(row.poll());
                }
            }
            result.add(colValues);
        }

        return result;
    }
}


class Pair<F, S> {
    F first;
    S second;

    Pair(F first, S second) {
        this.first = first;
        this.second = second;
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
