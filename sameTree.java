/**
 * San Wong
 * hswong1@uci.edu
 *
 * LeetCode 100. Same Tree
 * Determine if two binary tree is the same.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null || q==null){
            return (p==q);
        }
        
        return (p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}