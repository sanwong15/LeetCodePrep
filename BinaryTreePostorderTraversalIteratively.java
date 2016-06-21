/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 145. Binary Tree Postorder Traversal (Iteratively)
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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        if (root == null){
            return result;
        }
        
        while (!stack.isEmpty()){
            root = stack.pop();
            result.add(0,root.val);
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        
        
        
        return result;
        
    }
}