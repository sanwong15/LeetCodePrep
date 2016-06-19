/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 107. Binary Tree Level Order Traversal II
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
    List<List<Integer>> temp = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        bfs(root);
        reverse();
        return result;
    }
    
    public void bfs(TreeNode root){
        if (root == null) return;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> currentLevel = new ArrayList<Integer>();
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                TreeNode currentNode = q.remove();
                currentLevel.add(currentNode.val);
                if (currentNode.left!=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
                
            }
            temp.add(currentLevel);
        }
    }
    
    public void reverse(){
        int size = temp.size();
        for (int i=size-1; i>=0; i--){
            result.add(temp.get(i));
        }
    }
}