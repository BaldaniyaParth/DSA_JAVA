package Day22;

public class RemoveNthNodeFromEndList  {

    public static void main(String[] args) {
        // Define the input: head = [1,2,3,4,5], n = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;

        // Call the removeNthFromEnd method and print the result
        ListNode result = removeNthFromEnd(head, n);
        printList(result);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode newHead = reverseList(head), prev = null, curr = newHead;
        while (--n > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            // the problem is asking to delete the last node itself
            prev = curr;
            curr = curr.next;
            prev.next = null;
            head = reverseList(curr);
        } else {
            prev.next = curr.next;
            curr.next = null;
            head = reverseList(newHead);
        }
        return head;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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
