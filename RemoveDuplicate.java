public class RemoveDuplicate {

    public static void main(String[] args) {
        int [] numbs = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(numbs));
    }
    public static int removeDuplicates(int[] numb) {
        int j = 1;
        for (int i = 1; i < numb.length; i++) {
            if (numb[i] != numb[i - 1]) {
                numb[j] = numb[i];
                j++;
            }
        }
        return j;
    }
}
