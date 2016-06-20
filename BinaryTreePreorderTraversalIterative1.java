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
        
        if (root == null){
            return result;
        }
        
        while(root != null || !stack.isEmpty()){
            if (root!=null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                root = root.right;
            }

        }
        
        
        return result;
        
    }
}