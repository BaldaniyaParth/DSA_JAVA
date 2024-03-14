package Day46;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        int [] g = {1,2,3};
        int [] s = {1,1};
        System.out.println(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int cookies_numbers = s.length;
        if(cookies_numbers == 0)  return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int maximum_number_count = 0;
        int cookieIndex = cookies_numbers - 1;
        int childIndex = g.length - 1;
        while(cookieIndex >= 0 && childIndex >=0){
            if(s[cookieIndex] >= g[childIndex]){
                maximum_number_count++;
                cookieIndex--;
                childIndex--;
            }
            else{
                childIndex--;
            }
        }

        return maximum_number_count;

    }
}
