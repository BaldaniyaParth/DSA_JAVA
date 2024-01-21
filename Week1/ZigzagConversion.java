package Week1;

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if(numRows==1) return s;
        int n = s.length();
        int diff = 2*numRows-2;
        StringBuilder str = new StringBuilder();
        for(int i=0; i<numRows; i++){
            int idx = i;
            while(idx<n){
                str.append(s.charAt(idx));
                if(i!=0 && i!=numRows-1){
                    int secondIdx = idx + diff - 2*i;
                    if(secondIdx<n) str.append(s.charAt(secondIdx));
                }
                idx+=diff;
            }
        }
        return str.toString();
    }
}
