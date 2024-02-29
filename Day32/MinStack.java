package Day32;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStackClass obj = new MinStackClass();

        obj.push(5);
        obj.push(3);
        obj.push(7);
        obj.push(2);

        System.out.println("Current minimum value: " + obj.getMin());

        obj.pop();

        System.out.println("Current top value: " + obj.top());
        System.out.println("Current minimum value: " + obj.getMin());

    }

}

class MinStackClass {

    Stack<Integer> pushStack = new Stack<>(); //Stack to store all the values pushed
    Stack<Integer> minStack = new Stack<>();  //Stack to Store all the minimum values

    public void push(int val) {
        pushStack.push(val);
        if(minStack.isEmpty() || pushStack.peek() <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        if(pushStack.peek().equals(minStack.peek()))
        {

            minStack.pop();
        }

        pushStack.pop();
    }

    public int top() {
        return pushStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
