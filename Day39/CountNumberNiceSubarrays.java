package Day39;

public class CountNumberNiceSubarrays {

    public static void main(String[] args) {
        int [] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums,k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        return helper(nums, k, n) - helper(nums, k-1, n);
    }

    public static int helper(int[] nums, int k, int n) {
        int ans = 0;
        for(int i = 0, j = 0; j < n; j++) {
            if(nums[j] % 2 == 1) {
                k--;
            }
            while(k < 0) {
                if(nums[i] % 2 == 1) {
                    k++;
                }
                i++;
            }
            ans += j-i+1;
        }
        return ans;
    }
}
