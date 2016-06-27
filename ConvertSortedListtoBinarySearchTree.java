/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 109. Convert Sorted List to Binary Search Tree
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return construct(head, null);
    }
    
    public TreeNode construct(ListNode startNode, ListNode endNode){
        //Base case
        if (startNode == endNode) return null;
        
        //Find the middle node (that would be the root of the tree)
        ListNode fastPointer = startNode;
        ListNode slowPointer = startNode;
        
        while(fastPointer!= endNode && fastPointer.next != endNode){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        
        TreeNode root = new TreeNode(slowPointer.val);
        root.left = construct(startNode, slowPointer);
        root.right  = construct(slowPointer.next,endNode);
        
        return root;
    }
}