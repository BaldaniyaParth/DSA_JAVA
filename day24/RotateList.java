package day24;

public class RotateList {

    public static void main(String[] args) {
        // Creating the input linked list: head = [1,2,3,4,5]
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        SolutionOne solution = new SolutionOne();
        Node rotatedHead = solution.rotateRight(head, k);

        // Printing the rotated linked list
        while (rotatedHead != null) {
            System.out.print(rotatedHead.val + " ");
            rotatedHead = rotatedHead.next;
        }
    }
}

class SolutionOne {
    public Node rotateRight(Node head, int k) {
        /*if the linkedlist is empty return null*/
        if (head == null) return null;
        //counting the size of linkedlist
        int n = sizeOfList(head);
        if (n == 1) return head;
        k = k % n;
        int r = 0;
        //Running the loop for k times.
        while (r < k) {
            Node p = head;
            Node t = head.next;
            while (t.next != null) {
                t = t.next;
                p = p.next;
            }
            t.next = head;
            head = t;
            p.next = null;
            r++;
        }
        return head;
    }

    public int sizeOfList(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}

class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}
