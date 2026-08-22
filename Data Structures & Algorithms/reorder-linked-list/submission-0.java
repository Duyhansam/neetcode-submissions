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
    public void reorderList(ListNode head) {
        ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = null;
            ListNode curr = slow;
            ListNode nextTemp = null;
            while (curr != null) {
                nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            ListNode first = head;
            ListNode second = prev;
            ListNode temp1 = null;
            ListNode temp2 = null;

            while (second.next != null) {
            temp1 = first.next;
            temp2 =  second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;

            }
    }
}
