package Day19;

public class MiddleLinkedList {

    public static void main(String[] args) {
        // Create the linked list
        CustomListNode head = new CustomListNode(1);
        head.next = new CustomListNode(2);
        head.next.next = new CustomListNode(3);
        head.next.next.next = new CustomListNode(4);
        head.next.next.next.next = new CustomListNode(5);

        // Print the original linked list
        System.out.println("Original linked list:");
        printLinkedList(head);

        // Find the middle node
        CustomSolution solution = new CustomSolution();
        CustomListNode middleNode = solution.middleNode(head);

        // Print the middle node
        System.out.println("\nMiddle node value: " + middleNode.val);
    }

    // Utility method to print the linked list
    private static void printLinkedList(CustomListNode head) {
        CustomListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

class CustomListNode {
    int val;
    CustomListNode next;
    CustomListNode() {}
    CustomListNode(int val) { this.val = val; }
    CustomListNode(int val, CustomListNode next) { this.val = val; this.next = next; }
}

class CustomSolution {
    public CustomListNode middleNode(CustomListNode head) {
        CustomListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}