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
        StringBuilder sb = new StringBuilder();
        travel(list,root,sb);
        
        return list;
    }
    
    public void travel(List<String> l, TreeNode node, StringBuilder sb){
        if(node == null) return;
        
        int len = sb.length();
        sb.append(node.val);
        
        if(node.left == null && node.right == null){
            l.add(sb.toString());
            //reset StringBuilder
            sb.setLength(len);
            return;
        }
        
        sb.append("->");

        travel(l, node.left, sb);
        travel(l, node.right, sb);
        sb.setLength(len); // To get rid of the last "->"
    }
}