/**
 * San Wong
 * hswong1@uci.edu
 *
 * LeetCode 226: Invert Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }else{
            TreeNode temp;
            temp = root.right;
            root.right = root.left;
            root.left = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}