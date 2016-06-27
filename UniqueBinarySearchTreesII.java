/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 95. Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
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
    public List<TreeNode> generateTrees(int n) {
            if(n==0){
                return new ArrayList<TreeNode>();
            }else{
                return constructBST(1,n);
            }
                
    }
    
    public List<TreeNode> constructBST(int from, int n){
        List<TreeNode> result = new ArrayList<TreeNode>();

        
        for (int i=0; i<=n-1; i++){
            List<TreeNode> LST = constructBST(from,i);
            List<TreeNode> RST = constructBST(from+i+1,n-1-i);
            for (TreeNode l: LST){
                for (TreeNode r: RST){
                    TreeNode root = new TreeNode(from+i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        
        if(result.size() == 0){
            result.add(null);
        }
        
        return result;
    }
}