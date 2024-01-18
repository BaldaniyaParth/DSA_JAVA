package Week1;

public class BitwiseANDNumbersRange {

    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        System.out.println(rangeBitwiseAnd(left,right));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int res = right;
        while(right > left) {
            res = right & (right-1);
            right = res;
        }
        return res;
    }
}
