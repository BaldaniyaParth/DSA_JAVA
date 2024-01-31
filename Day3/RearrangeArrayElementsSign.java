package Day3;

import java.util.Arrays;

public class RearrangeArrayElementsSign {

    public static void main(String[] args) {
        int [] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    public static int[] rearrangeArray(int[] nums) {
        // Define array for storing the ans separately.
        int ans[]=new int[nums.length];

        // positive elements start from 0 and negative from 1.
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < nums.length; i++) {

            // Fill negative elements in odd indices and inc by 2.
            if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }

            // Fill positive elements in even indices and inc by 2.
            else {
                ans[posIndex] =  nums[i];
                posIndex += 2;
            }
        }

        return ans;
    }
}
