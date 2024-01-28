package Practice;

public class Compression {

    public static void main(String[] args) {
        char [] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }

    public static int compress(char[] chars) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < chars.length; ) {
            char c = chars[i];
            int cnt = 1;
            while (i + 1 < chars.length && c == chars[i + 1]) {
                i++;
                cnt++;
            }
            str.append(c);
            if (cnt > 1) {
                str.append(cnt);
            }
            i++;
        }
        char[] comp = str.toString().toCharArray();
        System.arraycopy(comp, 0, chars, 0, comp.length);
        return comp.length;
    }
}
