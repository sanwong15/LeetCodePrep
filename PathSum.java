/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) return (sum == root.val);
        
        int newSum = sum-(root.val);

        return (hasPathSum(root.left, newSum) || hasPathSum(root.right,newSum));
        
    }
}