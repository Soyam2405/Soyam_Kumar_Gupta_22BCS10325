/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;

        if (size == 0) return null;
        if (size == 1) return lists[0];

        ListNode first = mergeKLists(Arrays.copyOfRange(lists, 0, size / 2));
        ListNode second = mergeKLists(Arrays.copyOfRange(lists, size / 2, size));
        ListNode res = new ListNode();
        ListNode current = res;

        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }

            current = current.next;
        }

        if (first != null) current.next = first;
        else current.next = second;

        return res.next;
    }
}
