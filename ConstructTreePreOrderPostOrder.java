/**
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 106. Construct Binary Tree from Inorder and
 * Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int inOrderLen = inorder.length;
        int postOrderLen = postorder.length;
        int inStart = 0;
        int inEnd = inOrderLen-1;
        int postStart = 0;
        int postEnd = postOrderLen-1;

        
        return constructTree(inorder, postorder, inStart, inEnd, postStart, postEnd);
        
    }
    
    public TreeNode constructTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd){
        //Base case
        if (inStart>inEnd || postStart>postEnd) return null;
        
        
        TreeNode currentRoot = new TreeNode(postOrder[postEnd]);

        int inOrderRootIndex = 0;
        //Finding the rootIndex in inorder
        for (int i=0; i<=inEnd; i++){
            if (inOrder[i] == postOrder[postEnd]){
                inOrderRootIndex = i;
                break;
            }
        }
        
        /*
        Example: inOrder DBHEAFCG
                 poOrder DHEBFGCA
                 
                 root = A. inOrderRST = FCG (i.e: from rootIndex+1 to inEnd)
                           inOrderLST = DBHE (i.e.: from inStart to rootIndex-1)
                           postRST = FGC (from postStart + (rootIndex-inStart) to postEnd-1 )
        */
        
        
        TreeNode LST = constructTree(inOrder, postOrder, inStart, inOrderRootIndex-1, postStart, postStart+inOrderRootIndex-(inStart+1));
        TreeNode RST = constructTree(inOrder, postOrder, inOrderRootIndex+1, inEnd, postStart+(inOrderRootIndex-inStart), postEnd-1);
        
        currentRoot.left = LST;
        currentRoot.right = RST;
        
        return currentRoot;
    }
}