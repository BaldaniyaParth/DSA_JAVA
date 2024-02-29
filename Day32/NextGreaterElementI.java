package Day32;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int [] num1 = {4,1,2};
        int [] num2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(num1, num2)));
    }
    public static int[] nextGreaterElement(int[] num1, int[] num2) {
        Stack<Integer> s1=new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=num2.length-1;i>=0;i--){
            int num=num2[i];
            while(!s1.isEmpty() && s1.peek()<=num){
                s1.pop();
            }
            if(s1.isEmpty()) map.put(num,-1);
            else map.put(num,s1.peek());

            s1.push(num);
        }

        for (int i = 0; i < num1.length; i++) {
            num1[i] = map.getOrDefault(num1[i], -1);
        }
        return num1;
    }
}
