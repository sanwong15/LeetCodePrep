/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        TreeNode L = root.left;
        TreeNode R = root.right;
        root.left = null;
        root.right = L;
        
        while (root.right!=null){
            root = root.right;
        }
        
        root.right = R;
        
    }
    
}