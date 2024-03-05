package Day37;

import java.util.*;

public class OnlineStockSpan {

    public static void main(String[] args) {
        OnlineStockSpan stockSpanner = new OnlineStockSpan();

        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }

    Stack<Pair> st;

    public OnlineStockSpan() {
        st = new Stack<>();
    }

    class Pair {
        int price;
        int span;

        public Pair(int e, int c) {
            price = e;
            span = c;
        }
    }

    public int next(int price) {
        int span = 1;

        while (!st.isEmpty() && st.peek().price <= price) {
            span += st.peek().span;
            st.pop();
        }

        st.push(new Pair(price, span));

        return span;
    }
}
