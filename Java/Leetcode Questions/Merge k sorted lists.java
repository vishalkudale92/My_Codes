/*
Question : Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length==0)
            return null;
        
        if(lists.length == 1)
            return lists[0];
        
        ListNode[] result =  helper(lists);
        return result[0];
         
    }
    
    public ListNode[] helper(ListNode[] lists)
    {
        if(lists.length == 1)
            return lists;
        
        ListNode[] newList = null;
        int j = 0;
        if(lists.length % 2 == 0)
        {
            newList = new ListNode[lists.length / 2];
        }
        else
        {
            newList = new ListNode[lists.length / 2 +1];
        }
        
        int i = 0;
        while(i+1 < lists.length)
        {
            newList[j] = (mergeTwoLists(lists[i],lists[i+1]));
            i +=2;
            j++;
        }
        if(i < lists.length)
        {
            newList[j] = lists[i];
        }
        return helper(newList);
    }
    
    public ListNode mergeTwoLists(ListNode l1,ListNode l2)
    {
        ListNode head = null;
        ListNode runner = null;
        
        if(l1 == null && l2 == null)
            return head;
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1 !=null && temp2!=null)
        {
            ListNode temp = null;
            if(temp1.val < temp2.val)
            {
                temp = new ListNode( temp1.val);    
                temp1 = temp1.next;
            }
            else
            {
                temp = new ListNode( temp2.val);    
                temp2 = temp2.next;
            }
            
            if(head == null)
            {
                head = temp;
                runner = head;
            }
            else
            {
                runner.next = temp;
                runner = temp;
            }
        }
        
        while(temp1!=null)
        {
            ListNode temp = new ListNode(temp1.val);
            if(head == null)
            {
                head = temp;
                runner = head;
            }
            else
            {
                runner.next = temp;
                runner = temp;
            }
            temp1 = temp1.next;
        }
        
        while(temp2!=null)
        {
            ListNode temp = new ListNode(temp2.val);
            if(head == null)
            {
                head = temp;
                runner = head;
            }
            else
            {
                runner.next = temp;
                runner = temp;
            }
            temp2 = temp2.next;
        }
        return head;
    }
}