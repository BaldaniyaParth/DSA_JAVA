package Day18;

public class SumBeautyAllSubstrings {

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }

    public static int beautySum(String s) {
        int beautySum = 0;
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length -1; i++) {
            int[] count = new int[26];
            count[chrs[i] - 'a']++;
            for (int j = i + 1; j < chrs.length; j++) {
                count[chrs[j] - 'a']++;
                beautySum += getSum(count);
            }
        }
        return beautySum;
    }

    private static int getSum(int[] count) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int c : count) {
            max = Math.max(max, c);
            if (c > 0) {
                min = Math.min(c, min);
            }
        }
        return max - min;
    }
}
