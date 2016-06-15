/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root==null){
            return list;
        }
        
        String s = root.val+"";
        findPath(list,root,s);
        return list;
    }
    
    public void findPath(List<String> l,TreeNode n, String s){
        if (n.left==null && n.right==null){
            l.add(s);
            return;
        }
        
        if(n.left!=null){
            findPath(l,n.left,s+"->"+n.left.val);
        }
        
        if(n.right!=null){
            findPath(l,n.right,s+"->"+n.right.val);
        }
    }
}