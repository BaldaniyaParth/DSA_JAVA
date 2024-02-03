package Day6;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int [] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int totalSum = 0;
        int count = 0;

        for(int i=0; i < nums.length; i++){

            totalSum = totalSum + nums[i];
            int diff = totalSum - k;

            if(map.containsKey(diff)) count += map.get(diff);
            if(totalSum == k) count++;

            map.putIfAbsent(totalSum, 0);
            map.put(totalSum, map.get(totalSum) + 1);

        }

        return count;
    }
}
