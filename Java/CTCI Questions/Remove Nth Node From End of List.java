/*
Question :
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null)
            return head;
        ListNode end=head;
        ListNode toRemove = head;
        
        while(n > 0 && end.next != null)
        {
            end = end.next;
            n--;
        }
        
        if( n == 0)
        {
            while(end.next != null)
            {
                end = end.next;
                toRemove = toRemove.next;
            }    
            
            if(toRemove.next != null)
                toRemove.next = toRemove.next.next;
            else
                toRemove.next = null;
        }
        else
        {
            head = toRemove.next;
        }               
        return head;
    }
}