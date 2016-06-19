/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 103. Binary Tree Zigzag Level Order Traversal (Naive with two BFS)
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
    List<List<Integer>> LeftToRightResult = new ArrayList<List<Integer>>();
    List<List<Integer>> RightToLeftResult = new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return result;
        
        bfsLR(root);
        bfsRL(root);
        int LevelCount = LeftToRightResult.size();
        result.add(LeftToRightResult.get(0));
        for (int i=1; i<LevelCount; i++){
            if (i%2==0){
                result.add(LeftToRightResult.get(i));
            }else{
                result.add(RightToLeftResult.get(i));
            }
        }
        return result;
        
    }
    
    public void bfsLR(TreeNode root){
        if(root==null) return;
        
        Queue<TreeNode> qLR = new LinkedList<TreeNode>();
        qLR.add(root);
        
        while(!qLR.isEmpty()){
            List<Integer> currentLevelLR = new ArrayList<Integer>();
            int qLRSize = qLR.size();
            
            for (int i=0;i<qLRSize;i++){
                TreeNode currentNodeLR = qLR.remove();
                currentLevelLR.add(currentNodeLR.val);
                if(currentNodeLR.left != null){
                    qLR.add(currentNodeLR.left);
                }
                if(currentNodeLR.right != null){
                    qLR.add(currentNodeLR.right);
                }
                
            }
            LeftToRightResult.add(currentLevelLR);
        }
    }
    
    public void bfsRL(TreeNode root){
        if(root==null) return;
        
        Queue<TreeNode> qRL = new LinkedList<TreeNode>();
        qRL.add(root);
        
        while(!qRL.isEmpty()){
            List<Integer> currentLevelRL = new ArrayList<Integer>();
            int qRLSize = qRL.size();
            
            for (int i=0;i<qRLSize;i++){
                TreeNode currentNodeRL = qRL.remove();
                currentLevelRL.add(currentNodeRL.val);
                if(currentNodeRL.right != null){
                    qRL.add(currentNodeRL.right);
                }
                if(currentNodeRL.left != null){
                    qRL.add(currentNodeRL.left);
                }
                
            }
            RightToLeftResult.add(currentLevelRL);
        }
    }
}