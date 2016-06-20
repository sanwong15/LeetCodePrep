/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 144. Binary Tree Preorder Traversal (CLR)
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
    //Iteratively
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        if (root == null){
            return result;
        }
        
        while(!stack.isEmpty()){
            root = stack.pop();
            result.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            
            if(root.left!=null){
                stack.push(root.left);
            }

        }
        
        
        return result;
        
    }
}