package Day10;

import java.util.Arrays;

public class MinimumRotatedSortedArray {

    public static void main(String[] args) {
        int [] nums = {3,4,5,1,2};
        System.out.println(Arrays.toString(nums));
    }

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            //if left part is sorted:
            if (nums[low] <= nums[mid]) {
                // keep the minimum:
                ans = Math.min(ans, nums[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, nums[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }
}
