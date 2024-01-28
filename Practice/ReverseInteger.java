package Practice;

import java.util.Scanner;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println("Enter the Number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(reverse(a));
    }
    public static int reverse(int x) {
        int ans=0;
        while(x!=0){
            int ld=x%10;
            if(ans>Integer.MAX_VALUE/10 || ans<Integer.MIN_VALUE/10){
                return 0;
            }
            ans=ans*10+ld;
            x/=10;
        }
        return ans;
    }
}
