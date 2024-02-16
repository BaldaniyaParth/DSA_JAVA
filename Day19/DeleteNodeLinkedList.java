package Day19;

public class DeleteNodeLinkedList {
    public static void main(String[] args) {
        // Create the linked list
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Find the node with value 1
        ListNode nodeToDelete = head.next.next;

        // Print the original linked list
        System.out.println("Original linked list:");
        printLinkedList(head);

        // Delete the node
        Solution solution = new Solution();
        solution.deleteNode(nodeToDelete);

        // Print the modified linked list
        System.out.println("\nLinked list after deleting node:");
        printLinkedList(head);
    }

    // Utility method to print the linked list
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}