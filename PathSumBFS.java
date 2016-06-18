/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 112. Path Sum (Solved by BFS)
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
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> valueQueue = new LinkedList<Integer>();
        
        nodeQueue.add(root);
        valueQueue.add(root.val);
        
        while (!nodeQueue.isEmpty()){
            TreeNode currentNode = nodeQueue.remove();
            int currentSum = valueQueue.remove();
            
            if (currentNode.left == null && currentNode.right == null && currentSum == sum){
                return true;
            }
            
            if(currentNode.left != null){
                nodeQueue.add(currentNode.left);
                valueQueue.add(currentSum+currentNode.left.val);
            }
            
            if(currentNode.right != null){
                nodeQueue.add(currentNode.right);
                valueQueue.add(currentSum+currentNode.right.val);
            }
        }
        
        return false;
        
    }
}