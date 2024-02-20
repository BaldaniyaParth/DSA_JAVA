package Day23;

public class DeleteMiddleNodeLinkedList {

    public static void main(String[] args) {
        // Creating the linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        // Printing original list
        System.out.println("Original List:");
        printList(head);

        // Deleting middle element
        DeleteMiddleNodeLinkedList solution = new DeleteMiddleNodeLinkedList();
        ListNode newHead = solution.deleteMiddle(head);

        // Printing list after deletion
        System.out.println("\nList after deleting middle element:");
        printList(newHead);
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}