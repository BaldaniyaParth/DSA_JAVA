package Day16;

public class ReverseWordsString {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        int i=0,j=arr.length-1;
        while(i<j) {
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return String.join(" ", arr);
    }
}
