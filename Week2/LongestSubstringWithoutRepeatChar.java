package Week2;

public class LongestSubstringWithoutRepeatChar {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] charIndex = new int[128];

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            start = Math.max(charIndex[currentChar], start);

            maxLength = Math.max(maxLength, end - start + 1);

            charIndex[currentChar] = end + 1;
        }

        return maxLength;
    }
}
