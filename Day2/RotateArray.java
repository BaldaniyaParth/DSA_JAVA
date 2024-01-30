package Day2;
public class RotateArray {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k < 0){
            k += nums.length;
        }
        // Reverse first n-k elements
        Reverse(nums, 0, nums.length - k - 1);
        // Reverse last k elements
        Reverse(nums, nums.length - k, nums.length - 1);
        // Reverse whole array
        Reverse(nums, 0, nums.length - 1);
    }

    public static void Reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
