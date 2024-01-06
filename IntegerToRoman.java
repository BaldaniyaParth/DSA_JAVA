import java.util.Scanner;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println("Enter the Number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(intToRoman(a));
    }
    public static String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();

        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hens = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ths ={"","M","MM","MMM"};

        ans.append(ths[num / 1000]);
        ans.append(hens[(num % 1000) / 100]);
        ans.append(tens[(num % 100) / 10]);
        ans.append(ones[num % 10]);

        return ans.toString();
    }
}
