package Day31;

public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println("Top: " + obj.top()); // Expected output: Top: 2
        System.out.println("Pop: " + obj.pop()); // Expected output: Pop: 2
        System.out.println("Empty: " + obj.empty()); // Expected output: Empty: false
    }
}

class MyStack {
    public int top;
    public int[] arr;

    public MyStack() {
        top = -1;
        arr = new int[100];
    }

    public void push(int x) {
        top++;
        arr[top] = x;
    }

    public int pop() {
        int temp = arr[top];
        top--;
        return temp;
    }

    public int top() {
        return arr[top];
    }

    public boolean empty() {
        return top == -1;
    }
}
