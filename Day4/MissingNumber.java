package Day4;

public class MissingNumber {

    public static void main(String[] args) {
        int [] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int N = nums.length;

        //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N ; i++) {
            s2 += nums[i];
        }

        int missingNum = sum - s2;
        return missingNum;
    }
}
