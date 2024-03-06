package Day38;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s,k));
    }

    public static int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int largestCount = 0, beg = 0, maxlen = 0;

        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;

            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);

            if(end - beg + 1 - largestCount > k){
                arr[s.charAt(beg) - 'A']--;
                beg ++;
            }

            maxlen = Math.max(maxlen, end - beg + 1);
        }
        return maxlen;
    }
}
