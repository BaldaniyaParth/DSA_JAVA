package Week1;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        int [] nums = {10,2};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        StringBuilder s = new StringBuilder();
        Integer[] c = new Integer[n];
        for (int i = 0; i < n; i++)
            c[i] = nums[i];
        Arrays.sort(c, (x, y) -> {
            int dx = 10, dy = 10;
            while (dx <= x)
                dx *= 10;
            while (dy <= y)
                dy *= 10;
            return (int) (-dy * x - y + dx * y + x);
        });
        if (c[0] == 0)
            return "0";
        for (int f : c) {
            s.append(f);
        }
        return s.toString();
    }
}
