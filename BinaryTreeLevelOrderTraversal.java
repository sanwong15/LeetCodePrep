/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return result;
    }
    
    public void bfs(TreeNode root){
        if (root == null) return;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> currentLevel = new ArrayList<Integer>();
            int qSize = q.size();
            
            for (int i=0; i<qSize; i++){
                TreeNode currentNode = q.remove();
                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
                currentLevel.add(currentNode.val);
            }
            result.add(currentLevel);
        }
    }
}