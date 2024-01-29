package Day1;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortColors(nums)));
    }
    public static int [] sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1; // 3 pointers

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swapping nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;

            } else {
                // swapping nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
        return nums;
    }
}
