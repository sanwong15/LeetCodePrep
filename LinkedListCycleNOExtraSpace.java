/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 141. Linked List Cycle (No Extra Space)
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode point1 = head;
        ListNode point2 = head;
        
        while (point2 != null && point2.next != null){
            point1 = point1.next;
            point2 = point2.next.next;
            if (point1 == point2) return true;
        }
        
        return false;
    }
}