package Day13;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend,divisor));
    }

    public static int divide(int dividend, int divisor) {
        if(dividend==-2147483648 && divisor ==-1) return Integer.MAX_VALUE;
        int div=dividend/divisor;
        return div;
    }
}
