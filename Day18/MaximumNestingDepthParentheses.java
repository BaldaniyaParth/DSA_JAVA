package Day18;

public class MaximumNestingDepthParentheses {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int ans=0;
        int temp=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                temp++;
            }
            if(s.charAt(i)==')'){
                temp--;
            }
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}
