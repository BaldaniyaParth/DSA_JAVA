package Day42;

public class MergekSortedLists {

    public static void main(String[] args) {
        // Creating example linked lists
        ListNode[] lists = new ListNode[3];

        // First linked list: 1 -> 4 -> 5
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        // Second linked list: 1 -> 3 -> 4
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        // Third linked list: 2 -> 6
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        // Merging the lists
        ListNode mergedList = mergeKLists(lists);

        // Printing the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        int end = lists.length-1;

        while(end != 0) {
            int l = 0, r = end;
            while(l < r) {
                lists[l] = merge2Lists(lists[l], lists[r]);
                l++;
                r--;
            }
            end = r;
        }

        return lists[0];
    }

    public static  ListNode merge2Lists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode sentinel = new ListNode(-1), ptr = sentinel;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if(l1 != null)
            ptr.next = l1;
        else if(l2 != null)
            ptr.next = l2;
        return sentinel.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}