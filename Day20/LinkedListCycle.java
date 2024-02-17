package Day20;

public class LinkedListCycle {

    public static void main(String[] args) {
//        Create a sample linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 5 -> 2
        CustomListNode head = new CustomListNode(1);
        head.next = new CustomListNode(2);
        head.next.next = new CustomListNode(3);
        head.next.next.next = new CustomListNode(4);
        head.next.next.next.next = new CustomListNode(5);
        head.next.next.next.next.next = head.next; // creating a cycle

        LinkedListCycle solution = new LinkedListCycle();

        // Check if the list has a cycle
        boolean hasCycle = solution.hasCycle(head);

        if (hasCycle)
            System.out.println("The linked list has a cycle.");
        else
            System.out.println("The linked list does not have a cycle.");
    }

    public boolean hasCycle(CustomListNode head) {
        CustomListNode slow = head; // Initialize slow pointer to head
        CustomListNode fast = head; // Initialize fast pointer to head

        // Check if the list is null or has only one node
        if (head == null || head.next == null)
            return false;

        // Iterate through the list with two pointers
        while (fast != null) {
            slow = slow.next; // Move slow pointer by one step

            // Check if fast or its next node is null, if yes, return false
            if (fast.next == null)
                return false;

            fast = fast.next.next; // Move fast pointer by two steps

            // If fast and slow pointers meet, it indicates a cycle
            if (fast == slow)
                return true;
        }

        return false; // If fast pointer reaches the end, there's no cycle
    }
}


 class CustomListNode {
     int val;
     CustomListNode next;
     CustomListNode(int x) {
         val = x;
         next = null;
     }
 }