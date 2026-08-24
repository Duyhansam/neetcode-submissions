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
    public ListNode reverseKGroup(ListNode head, int k) {
               ListNode check = head;
        for (int i = 0; i < k; i++) {
            if (check == null) return head;
            check = check.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextTemp = null;
        for (int i = 0; i < k; i++) {
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        head.next = reverseKGroup(curr , k);
        return prev; 
    }
}
