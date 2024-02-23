package Day26;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> res= new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }

    public static void backtrack(ArrayList<String> res,String curr,int open, int close,int n)
    {
        if(curr.length()==2*n)
        {
            res.add(curr);
            return;
        }
        if(open<n)
        {
            backtrack(res,curr+"(",open+1,close,n);
        }
        if(close<open)
        {
            backtrack(res,curr+")",open,close+1,n);
        }

    }
}
