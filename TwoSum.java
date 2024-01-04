import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int [] numb = {2,7,12,15,20};
        int target = 17;
        System.out.println(Arrays.toString(twoSum(numb, target)));
    }
    public static int[] twoSum(int[] numbs, int target) {
        int n = numbs.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbs[i] + numbs[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}