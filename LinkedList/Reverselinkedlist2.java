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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode curr = head, temp = null;

        for (int i = 0; i < left - 1; i++) {
            temp = curr;
            curr = curr.next;
        }

        ListNode ptr = curr;
        ListNode prev = temp;
        ListNode next = null;
        int n = right - left + 1;

        while (n-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (temp != null) {
            temp.next = prev;
        } else {
            head = prev;
        }

        ptr.next = curr;

        return head;
    }
}
