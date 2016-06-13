/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 206. Reverse Linked List
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode pointer1 = head;
        ListNode pointer2 = pointer1.next;
        
        head.next = null;
        while(pointer1 != null && pointer2 !=null){
            ListNode temp = pointer2.next;
            pointer2.next = pointer1;
            pointer1 = pointer2;
            pointer2 = temp;
        }
        
        return pointer1;
    }
}