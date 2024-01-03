import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int palindrome = sc.nextInt();
        System.out.println(isPalindrome(palindrome));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int a = x;
        int y = 0;
        while (x != 0) {
            y = 10 * y + x % 10;
            x = x/10;
        }
        return a == y;
    }
}
