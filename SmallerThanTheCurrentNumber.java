import java.util.Arrays;

public class SmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        int [] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counter = new int[101];
        int n =nums.length;

        for(int i=0; i<n; i++)
            counter[nums[i]]++;

        for(int i=1; i< 101; i++)
            counter[i]=counter[i]+counter[i-1];

        for(int i=0; i< n; i++)
        {
            if(nums[i]==0)
                nums[i]=0;
            else
                nums[i]=counter[nums[i]-1];

        }

        return nums;
    }
}
