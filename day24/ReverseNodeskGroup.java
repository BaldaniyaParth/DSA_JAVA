package day24;

public class ReverseNodeskGroup {

    public static void main(String[] args) {
        // Creating the input linked list: head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseKGroup(head, k);

        // Printing the reversed linked list
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preTail = null;
        ListNode curHead = head;
        ListNode curTail = head;
        ListNode nextHead = null;

        while (curHead != null) {
            int count = 1;

            while (curTail.next != null && count < k) {
                curTail = curTail.next;
                count++;
            }

            if (count != k) {
                break;
            }

            nextHead = curTail.next;

            curTail.next = null;

            if (preTail != null) {
                preTail.next = null;
            }

            curTail = reverse(curHead);

            if (preTail != null) {
                preTail.next = curTail;
            } else {
                head = curTail;
            }

            curHead.next = nextHead;

            preTail = curHead;
            curHead = nextHead;
            curTail = nextHead;
        }

        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = head;

        while (curNode != null) {
            nextNode = nextNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
