/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //idea: find the interval between m and n first. Set up two pointers. Move both at once.
        if (head == null || head.next == null || m == n) {
            return head;
        }

        int interval = n-m;
        ListNode pt1 = new ListNode(0);
        ListNode dummy = new ListNode(0); //Create dummy node to preseve head. So that it won't get messed up.
        pt1 = dummy;
        dummy.next = head;
        
        for (int j=0; j<m-1; j++){
            pt1 = pt1.next;
        }
        /*pt1 is now locate right before M
        Example: m = 3 -> j iterate from 0,1 (2 times)
        So given 1-2-3-4-5 as input. 
        when j=0, pt1 becomes head.
        when j=1; pt1 becomes 2. Which is the node right before M (i.e: 3)
        */
        
        ListNode pt2 = pt1.next; //pt2 at node 3 now
        ListNode nodeM = pt1.next;
        ListNode nodeN = null;
        
        for(int i=0; i<=interval; i++){
            ListNode nextNode = pt2.next;
            pt2.next = nodeN;
            nodeN = pt2;
            pt2 = nextNode;
        }

        
        //Flip
        nodeM.next = pt2;
        pt1.next = nodeN;

        return dummy.next;
    }
}