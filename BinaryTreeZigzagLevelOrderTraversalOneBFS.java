/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 103. Binary Tree Zigzag Level Order Traversal (One BFS)
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return result;
        
        zigzagBFS(root);
        return result;
        
    }
    
    public void zigzagBFS(TreeNode root){
        if(root==null) return;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            List<Integer> currentLevel = new ArrayList<Integer>();
            int qSize = q.size();
            
            for (int i=0;i<qSize;i++){
                TreeNode currentNode = q.remove();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
                
            }
            //Add to result:
            if(level%2 ==1){
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            level++;
        }
    }
}