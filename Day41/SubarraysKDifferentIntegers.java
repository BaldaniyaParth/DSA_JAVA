package Day41;

import java.util.HashMap;

public class SubarraysKDifferentIntegers {

    public static void main(String[] args) {
        int [] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums,k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums,k)-f(nums,k-1);
    }

    public static int f(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int si=0;
        int ei=0;
        int count=0;
        while(ei<nums.length){
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);
            while(map.size()>k){
                if(map.get(nums[si]) > 1) {
                    map.put(nums[si], map.get(nums[si]) - 1);
                } else {
                    map.remove(nums[si]);
                }
                si++;
            }
            count+=ei-si+1;
            ei++;
        }
        return count;
    }
}
