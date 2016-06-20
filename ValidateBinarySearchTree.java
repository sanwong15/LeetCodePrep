/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
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
    public boolean isValidBST(TreeNode root) {
        return validBST(root,null,null);

    }
    
    public boolean validBST(TreeNode root, Integer max, Integer min){
        if (root == null) return true;
        
        if(max!=null && root.val >= max){
            return false;
        }
        
        if(min!=null && root.val <= min){
            return false;
        }

        return validBST(root.left, root.val,min) && validBST(root.right,max,root.val);
    }
    
    
}