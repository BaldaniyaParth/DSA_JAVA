package Day1;

public class CheckArraySortedRotated {
    public static void main(String[] args) {
        int [] nums = {3,4,5,1,2};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {
        int i = 0, flag = 0;
        boolean result = true;

        while(i < nums.length-1){
            if(flag == 0){
                if(nums[i] > nums[i+1]){
                    flag = 1;
                }
            }else{
                if(nums[0] < nums[i] || nums[i] > nums[i+1])                 {
                    result = false;
                    break;
                }
            }
            i++;
        }
        if(flag == 1 && nums[0] < nums[i]) {
            result = false;
        }
        return result;
    }

}
