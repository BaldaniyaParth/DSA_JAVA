package Week2;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(trailingZeroes(n));
    }

    public static int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
