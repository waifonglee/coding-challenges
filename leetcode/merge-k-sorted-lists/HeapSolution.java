/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//using priorityqueue
//second method to do 2 array merging k/2 times (divide and conquer) --> less space
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        ListNode resPtr = dummy;
        
        if (lists.length == 0 || lists == null) {
            return null;
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
            lists.length,
            (node1, node2) -> Integer.compare(node1.val, node2.val)
        );
        
        for (int j = 0; j < lists.length; j ++) {
            if (lists[j] != null) {
                heap.add(lists[j]);
            }
        }
        
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            resPtr.next = new ListNode(min.val);
            resPtr = resPtr.next;
            if (min.next != null) {
                heap.add(min.next);
            }
        }
        
        return res.next;
    }
}
