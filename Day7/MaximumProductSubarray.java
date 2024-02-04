package Day7;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int [] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int prod1 = nums[0], prod2 = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.min(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;

            result = Math.max(result, prod1);
        }

        return result;
    }
}
