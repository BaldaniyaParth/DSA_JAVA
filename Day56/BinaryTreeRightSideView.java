package Day56;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNodeOne root = new TreeNodeOne(1);
        root.left = new TreeNodeOne(2);
        root.right = new TreeNodeOne(3);
        root.left.right = new TreeNodeOne(5);
        root.right.right = new TreeNodeOne(4);

        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();

        List<Integer> result = solution.rightSideView(root);
        System.out.println("Right Side View: " + result);
    }

    public static List<Integer> rightSideView(TreeNodeOne root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNodeOne curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }

        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
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