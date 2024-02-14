package Day17;

public class SortCharactersFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[128];
        for (int i = 0; i < chrs.length; ++i)
            counts[chrs[i]]++;

        for (int pos = 0; pos < chrs.length;) {
            int cmax = 0;
            for (char i = 0; i < counts.length; ++i)
                if (counts[i] > counts[cmax]) cmax = i;

            while (counts[cmax]-- > 0)
                chrs[pos++] = (char)cmax;
        }

        return new String(chrs);
    }
}
