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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode front = head;
        if(head==null || head.next==null){
            return head;
        }
        int n = 1;
        while(front.next!=null){
            front= front.next;
            n++;
        }
        front.next = head;
        front = head;
        k = k%n;
        for(int i=0;i<n-k-1;i++){
            front = front.next;
        }
        head = front.next;
        front.next = null;
        return head;
    }
}
