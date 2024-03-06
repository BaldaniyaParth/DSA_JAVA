package Day38;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }

    public static int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        for (j=0;j<nums.length;j++) {
            if(nums[j]==0) k--;
            if(k<0 && nums[i++]==0)k++;
        }
        return j-i;
    }
}
