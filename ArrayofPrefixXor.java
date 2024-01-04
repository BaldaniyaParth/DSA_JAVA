
import java.util.Arrays;

public class ArrayofPrefixXor {

    public static void main(String[] args) {
        int [] prefix = {5,2,0,3,1};
        System.out.println(Arrays.toString(findArray(prefix)));
    }

    public static int[] findArray(int[] pref) {
        for (int i = pref.length - 1; i > 0; --i)

            pref[i] ^= pref[i - 1];

        return pref;
    }
}




