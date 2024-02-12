package Day15;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());

        for (int j : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> i : arr) {
                List<Integer> subset = new ArrayList<>(i);
                subset.add(j);
                temp.add(subset);
            }
            arr.addAll(temp);
            System.out.println(arr);
        }
        return arr;
    }
}
