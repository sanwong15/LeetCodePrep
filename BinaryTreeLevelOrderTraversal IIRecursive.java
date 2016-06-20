/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 107. Binary Tree Level Order Traversal II (Recursive)
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        recursiveVist(result, root, 0);
        Collections.reverse(result);
        return result;
    }
    
    public void recursiveVist(List<List<Integer>> list, TreeNode root, int level){
        if (root == null) return;
        
        //Create new List<Integer> for a new level
        if (list.size() < level+1){
            list.add(new ArrayList<Integer>());
        }
        
        list.get(level).add(root.val);
        recursiveVist(list,root.left,level+1);
        recursiveVist(list,root.right,level+1);
        
    }

}