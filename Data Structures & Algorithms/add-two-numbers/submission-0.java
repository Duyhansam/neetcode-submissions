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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode dummy =  new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
            int result =0;
            int ditgit = 0;
        while (p1 != null || p2 != null || carry != 0) {
            int sum = 0;
            if (p1 != null) sum += p1.val;
            if (p2 != null) sum += p2.val;
            result = sum + carry;
            ditgit = result % 10;
            carry = result / 10;
            tail.next = new ListNode(ditgit);
            tail = tail.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        return dummy.next;   
    }
}
