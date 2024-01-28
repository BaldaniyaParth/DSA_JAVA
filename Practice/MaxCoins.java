package Practice;

import java.util.Arrays;
public class MaxCoins {
    public static void main(String[] args) {
        int [] piles = {2,4,1,2,7,8};
        System.out.println(maxCoins(piles));
    }
    public static int maxCoins(int[] piles) {
        int max=0;
        Arrays.sort(piles);
        int i=0;
        int j=piles.length-1;
        while(i<j){
            max=max+piles[j-1];
            i=i+1;
            j=j-2;
        }
        return max;
    }
}
