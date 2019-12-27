/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = null;
        ListNode resPtr = res;
        ListNode l1ptr = l1;
        ListNode l2ptr = l2;
        while (l1ptr != null && l2ptr != null) {
            int sum = l1ptr.val + l2ptr.val + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            
            if (res != null) {
                ListNode node = new ListNode(sum);
                resPtr.next = node;
                resPtr = resPtr.next;
            } else {
                ListNode node = new ListNode(sum);
                res = node;
                resPtr = node;
                
            }
            
            l1ptr = l1ptr.next;
            l2ptr = l2ptr.next;
            
        }
        
        while (l1ptr != null) {
            int sum = l1ptr.val + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            
            ListNode node = new ListNode(sum); 
            resPtr.next = node;
            l1ptr = l1ptr.next;
            resPtr = resPtr.next;
        }
        
        while (l2ptr != null) {
            int sum = l2ptr.val + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
    
            ListNode node = new ListNode(sum);
            resPtr.next = node;
            l2ptr = l2ptr.next;
            resPtr = resPtr.next;
        }
        
        if (carry != 0) {
            resPtr.next = new ListNode(carry);
        }
        
        return res;
    }
}
