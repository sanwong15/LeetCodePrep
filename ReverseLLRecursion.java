/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 206. Reverse Linked List (Recursion)
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
        //Base case
        if(head == null || head.next == null) return head;
        
        ListNode secondNode = head.next; //We are recursively passing in new head.
        
        head.next = null;
        
        ListNode headOfRest = reverseList(secondNode);
        
        //As we earlier set "head" (i.e. head of every recusion we called) to null. we need to fix the null pointer now
        secondNode.next = head;
        
        return headOfRest;
    }
}