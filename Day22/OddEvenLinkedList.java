package Day22;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        // Define the input: head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Call the oddEvenList method and print the result
        ListNode result = oddEvenList(head);
        printList(result);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode head2 = head.next;
        ListNode first = head, second = head.next, prev = null;
        while (second != null && first != null) {
            first.next = second.next;
            prev = first;
            first = first.next;
            if (first != null) {
                second.next = first.next;
                second = second.next;
            }
        }
        // If the number of nodes is odd -- (second == null)
        // The tail of the odd set of nodes is 'first'
        if (second == null) {
            first.next = head2;
        }
        // If the number of nodes is even -- (first == null)
        // The tail of the odd set of nodes is 'prev'
        else {
            prev.next = head2;
        }
        return head;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
