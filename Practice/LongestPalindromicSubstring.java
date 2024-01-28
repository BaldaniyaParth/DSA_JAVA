package Practice;

public class LongestPalindromicSubstring {

    public static int start = 0;
    public static int end = 0;
    public static void main(String[] args) {
        String s = "babad";
        longestPalindrome(s);
    }
    public static void longestPalindrome(String s) {
        char[] c = s.toCharArray();
        getString(c, 0);
        System.out.println(s.substring(start, end + 1));
    }
    public static void getString(char[] c, int p) {
        int a = p;
        int b = p;
        int n = c.length;
        if (p == n - 1 || n - p < (end - start + 1) / 2) {
            return;
        }
        if (p != 0 && c[p] == c[p - 1]) {
            getString(c, p + 1);
            return;
        }
        // 1. expand middle
        while (b < n - 1 && c[b] == c[b + 1]) {
            b++;
        }
        p = b;
        // 2. expand left and right
        while (a > 0 && b < n - 1 && c[a - 1] == c[b + 1]) {
            a--;
            b++;
        }
        if ((b - a) > (end - start)) {
            end = b;
            start = a;
        }
        getString(c, p + 1);
    }
}
