/**
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 104. Maximum Depth of Binary Tree (With DFS)
 * 
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes alongthelongest path from the root node
 * down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res.get(0);
    }
    
    private void dfs(List<Integer> res, TreeNode curr, int count){
        count ++;
        if (curr.left == null && curr.right == null){
            if (res.isEmpty()){
                //When Stack is empty, this is the end of DFS
                res.add(count);
            }
            if (count>res.get(0)){
                res.set(0,count);
                return;
            }
        }
        
        if (curr.left != null){
            dfs(res,curr.left, count);
        }
        
        if(curr.right != null){
            dfs(res, curr.right, count);
        }
    }
}