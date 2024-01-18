package Week1;

public class AddBinary {

    public static void main(String[] args) {
       String a = "11";
       String b = "1";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, sum = 0;
        while(i >= 0 || j >= 0){
            sum = sum / 2;

            if(i >= 0)
                sum += a.charAt(i--)-'0';
            if(j >= 0)
                sum += b.charAt(j--)-'0';

            sb.append(sum%2);
        }
        if(sum/2 != 0)sb.append(1);
        return sb.reverse().toString();
    }
}
