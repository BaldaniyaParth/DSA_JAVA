package Day23;

public class SortList {

    public static void main(String[] args) {
        // Creating the linked list
        Node head = new Node(-1);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(0);

        // Printing original list
        System.out.println("Original List:");
        printList(head);

        // Sorting the list
        Solution solution = new Solution();
        Node sortedHead = solution.sortList(head);

        // Printing sorted list
        System.out.println("\nList after sorting:");
        printList(sortedHead);
    }

    // Utility method to print the linked list
    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}


class Solution {
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = findMiddle(head);
        Node head2 = mid.next;
        mid.next = null;
        Node t1 = sortList(head);
        Node t2 = sortList(head2);
        return merge(t1, t2);
    }

    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2) {
        Node head;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        Node t = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                t.next = head1;
                head1 = head1.next;
                t = t.next;
            } else {
                t.next = head2;
                head2 = head2.next;
                t = t.next;
            }
        }
        if (head1 == null) {
            t.next = head2;
        }
        if (head2 == null) {
            t.next = head1;
        }
        return head;
    }
}



class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}