package Day21;

public class LinkedListCycleII {

    public static void main(String[] args) {
        // Create a sample linked list with a cycle for testing
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeMinus4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeMinus4;
        nodeMinus4.next = node2; // Cycle formed

        // Call the detectCycle method and print the result
        Solution solution = new Solution();
        ListNode cycleStartNode = solution.detectCycle(head);
        if (cycleStartNode != null) {
            System.out.println("Cycle detected. Start node value: " + cycleStartNode.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }

}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slowPtr = head;
        ListNode fastPtr = head.next.next;

        ListNode matchNode = null;

        while (slowPtr != null && fastPtr != null) {
            if (slowPtr == fastPtr) {
                matchNode = slowPtr;
                break;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr != null)
                fastPtr = fastPtr.next;
        }

        if (matchNode == null)
            return null;

        int outOfLoopLength = 0;
        int loopLength = 1;

        ListNode loopStepper = matchNode.next;
        while (loopStepper != null && loopStepper != matchNode) {
            loopStepper = loopStepper.next;
            loopLength++;
        }

        ListNode outOfLoop = head;
        loopStepper = head;

        int ct = 0;
        while (ct < loopLength) {
            loopStepper = loopStepper.next;
            ct++;
        }

        while (outOfLoop != loopStepper) {
            outOfLoop = outOfLoop.next;
            loopStepper = loopStepper.next;
        }

        return loopStepper;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
