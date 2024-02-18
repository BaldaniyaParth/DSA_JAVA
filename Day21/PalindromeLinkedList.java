package Day21;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // Create a sample linked list for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        // Call the isPalindrome method and print the result
        Solution1 solution = new Solution1();
        boolean isPalindrome = solution.isPalindrome(head);
        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}

class Solution1 {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = find_mid(head);
        Node half = mid.next;
        mid.next = null;
        Node head2 = reverse(half);
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public Node find_mid(Node head) {
        Node slow = head;
        Node fast = head;
        Node t = head;
        while (fast != null && fast.next != null) {
            t = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return t;
    }

    public Node reverse(Node head) {
        Node dummy = null;
        Node t = head;
        while (t != null) {
            Node nextnode = t.next;
            t.next = dummy;
            dummy = t;
            t = nextnode;
        }
        return dummy;
    }
}
class Node {
    int val;
    Node next;

    Node() {}

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}