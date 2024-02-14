package Day17;

public class RotateString {

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s,goal));
    }

    public static boolean rotateString(String s, String goal) {
        int n1 = s.length();

        int n2 = goal.length();

        if(n1 != n2)
        {
            return false;
        }

        StringBuilder str = new StringBuilder(goal);

        str=str.append(str);

        return (str.indexOf(s)!=-1);

    }
}
