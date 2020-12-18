/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 Given a singly linked list, group all odd nodes together followed by the even nodes. Please
 note here we are talking about the node number and not the value in the nodes.
 You should try to do it in place. The program should run in O(1) space complexity and
 O(nodes) time complexity.
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
        
    }
}