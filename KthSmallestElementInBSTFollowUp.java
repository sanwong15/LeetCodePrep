/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 230. Kth Smallest Element in a BST (FOLLOW UP: Solve it by Iterative InOrder)
 * Given a binary search tree, write a function kthSmallest to find the kth 
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need
 * to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!= null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
    
    

}