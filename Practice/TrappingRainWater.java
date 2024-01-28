package Practice;

public class TrappingRainWater {

    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            ans += (lmax < rmax) ? lmax - height[l++] : rmax - height[r--];
        }
        return ans;
    }
}
