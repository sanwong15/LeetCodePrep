/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 21. Merge Two Sorted Lists (Iterative)
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        1-3-5-7  &  2-4-6-8
        */
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode temp;
        
        if(l1.val > l2.val){
            //flip order (i.e flip between 1 and 2)
            temp = l2;
            l2 = l1;
            l1 = temp;
        }
        
        ListNode pivot = l1;
        while (l2!=null){
            while(pivot.next!=null && pivot.next.val <= l2.val){
                pivot = pivot.next;
            }
            //where pivot.val > l2.val
            temp = pivot.next;
            pivot.next = l2;
            l2= temp;
        }
        
        return l1;

    }
}