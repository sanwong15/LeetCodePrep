/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 173. Binary Search Tree Iterator
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> minNodeStack = new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    public void push(TreeNode node){
        while (node != null){
            minNodeStack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!minNodeStack.isEmpty());

    }

    /** @return the next smallest number */
    public int next() {
        //Smallest number in the BST is the LeftMost Element
        TreeNode currentMin = minNodeStack.pop();
        push(currentMin.right);
        return currentMin.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */