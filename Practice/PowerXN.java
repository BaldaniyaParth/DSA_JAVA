package Practice;

import java.util.Scanner;

public class PowerXN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of X");
        double a = sc.nextDouble();
        System.out.println("Enter number of N");
        int b = sc.nextInt();
        System.out.println(myPow(a,b));
    }
    public static double myPow(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return pow;
    }
}
