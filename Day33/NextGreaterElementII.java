package Day33;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int [] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        int len = nums.length;
        for(int i = (2*len)-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%len]){
                stack.pop();
            }
            if(i < len){
                if(!stack.isEmpty()){
                    ans[i%len] = stack.peek();
                }
                else{
                    ans[i%len] = -1;
                }
            }
            stack.push(nums[i%len]);
        }
        return ans;
    }
}
