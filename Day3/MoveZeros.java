package Day3;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }

    public static int [] moveZeroes(int[] nums) {
        int j = -1;
        //place the pointer j:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        //no non-zero elements:
        if (j == -1) return nums;

        //Move the pointers i and j
        //and swap accordingly:
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                //swap a[i] & a[j]:
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }

        return nums;
    }
}
