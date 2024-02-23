package Day26;

public class CountGoodNumbers {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countGoodNumbers(n));
    }

    public static long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n+1)/2;

        // multiplying 5 by even because there could only be 5 even numbers between 0-9
        // multiplying 4 by odd because there could only be 4 prime numbers between 0-9
        return (int)(pow(5,even) * pow(4,odd) % MOD);
    }

    public static long pow(long x, long n){

        if(n==0)
            return 1;

        long temp = pow(x,n/2);

        // If n is even
        if(n%2==0){
            return (temp * temp)% MOD;
        }
        // If n is odd
        else{
            return (x * temp * temp)% MOD;
        }
    }
}
