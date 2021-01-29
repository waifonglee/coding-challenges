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
    /*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

    Follow up: Could you do this in one pass?
    
    keep a current node and a current + n node
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode plusN = head;
        for (int i = 0; i < n; i ++ ) {
            plusN = plusN.next;
        }
        if (plusN == null) {
            return head.next;
        }
        
        while(plusN.next != null) {
            curr = curr.next;
            plusN = plusN.next;
        }
        
        curr.next = curr.next.next;
        return head;
        
    }
}