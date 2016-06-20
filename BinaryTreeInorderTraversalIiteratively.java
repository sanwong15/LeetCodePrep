/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 94. Binary Tree Inorder Traversal (iteratively)
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inOrderList = new ArrayList<Integer>();
        
        while(true){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
            if (stack.isEmpty()){
                break;
            }
            
            TreeNode currentNode = stack.pop();
            inOrderList.add(currentNode.val);
            root = currentNode.right;

        }

        
        return inOrderList;
    }
}