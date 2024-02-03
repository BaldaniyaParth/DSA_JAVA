package Day6;

public class SingleNumber {

    public static void main(String[] args) {
        int [] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        //size of the array:
        int n = nums.length;

        // XOR all the elements:
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
