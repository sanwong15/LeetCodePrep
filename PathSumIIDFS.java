/**
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 113: Path Sum II (Solved by DFS)
 * Given a binary tree and a sum, find all root-to-leaf paths where each
 * path's sum equals the given sum.
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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        //implement the stack with the ArrayList
        List<Integer> innerList = new ArrayList<Integer>();
        
        
        if (root == null) return result;
        
        //DFS
        innerList.add(root.val);
        dfs(root,sum,innerList);
        return result;
        
    }
    
    public void dfs(TreeNode node, int sum, List<Integer> innerList){
        //Base case: 
        if (node.left == null && node.right == null && node.val == sum){
            result.add(innerList);
            return;
        }
        
        if (node.left != null){
            List<Integer> temp = new ArrayList<Integer>(innerList);
            temp.add(node.left.val);
            dfs(node.left,sum-node.val,temp);
        }
        
        if (node.right != null){
            List<Integer> temp = new ArrayList<Integer>(innerList);
            temp.add(node.right.val);
            dfs(node.right,sum-node.val,temp);
        }
    }
}