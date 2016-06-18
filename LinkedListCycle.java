/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 141. Linked List Cycle
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
        
        HashSet<ListNode> set = new HashSet<ListNode>();
        
        ListNode currentNode = head;
        while(currentNode != null && currentNode.next!=null){
            if (!set.contains(currentNode)){
                set.add(currentNode);
                currentNode = currentNode.next;
            }else{
                return true;
            }
        }
        
        return false;
    }
}