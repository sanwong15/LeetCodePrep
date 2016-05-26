/**
 * San Wong
 * hswong1@uci.edu
 *
 * LeetCode 100. Same Tree
 * Determine if two binary tree is the same.
 *
 * }
 */

public class sameBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(b.root);
		
		Solution s = new Solution();
		
		BinarySearchTree a = new BinarySearchTree();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.insert(5);
		a.insert(6);
		a.insert(7);
		a.insert(8);
		
		BinarySearchTree c = new BinarySearchTree();
		c.insert(1);
		c.insert(2);
		c.insert(3);
		c.insert(4);
		c.insert(5);
		c.insert(6);
		c.insert(7);
		c.insert(8);
		System.out.println("Testing isSameTree method on BT a and BT c");
		System.out.println(s.isSameTree(a.root, c.root));
		

	}

}

class Solution{
	public boolean isSameTree(BTNode p, BTNode q){
		if(p==null || q==null){
			return (p==q);
		}
		
		return (p.data == q.data && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
	}
}


class BTNode{
	int data;
	BTNode left;
	BTNode right;
	
	public BTNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}


class BinarySearchTree{
	public static BTNode root;
	
	//Constructor
	public BinarySearchTree(){
		this.root = null;
	}
	
	//Find time would be O(logN)
	public boolean find(int id){
		BTNode current = root;
		while(current!=null){
			if(current.data == id){
				return true;
			}else if(current.data > id){
				current = current.left;
			}else if(current.data < id){
				current = current.right;
			}
		}
		
		return false;
	}
	
	public void insert(int id){
		BTNode newNode = new BTNode(id);
		if (root == null){
			root = newNode;
			return;
		}
		//Travel through the existing tree 
		BTNode current = root;
		BTNode parent = null;
		while(true){
			parent = current;
			if (id<current.data){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			}else{
				//here means if id>current.data
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public boolean delete(int id){
		//Three cases: 
		// (1) Node to be deleted is the left node (no children)
		// (2) Node to be deleted has only one child
		// (3) Node to deleted has two children
		BTNode parent = root;
		BTNode current = root;
		boolean isLeftChild = false;
		while (current.data != id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				//For case that current.data<id
				isLeftChild = false;
				current = current.right;
			}
			
			if(current == null){
				return false;
			}
		}// End of while
		
		//At the point, we have found the matching ID. Let's handle 3 diff cases
		//Case 1
		if(current.left == null && current.right == null){
			if (current == root){
				root = null;
			}
			if (isLeftChild == true){
				parent.left = null;
			}
			if (isLeftChild == false){
				parent.right = null;
			}
		}
		
		//Case 2
		else if (current.right == null){
			if(current == root){
				root = current.left;
			}else if (isLeftChild){
				parent.left = current.left;
			}else if (!isLeftChild){
				parent.right = current.left;
			}
		}
		else if (current.left == null){
			if(current == root){
				root = current.right;
			}else if (isLeftChild){
				parent.left = current.right;
			}else if (!isLeftChild){
				parent.right = current.right;
			}
		}
		
		//Case 3
		else if(current.left!=null && current.right!=null){
			//Here we would have to balance the tree by finding the smaller item
			// in the right subtree.
			BTNode successor = getSuccessor(current);
			if (current == root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else if(!isLeftChild){
				parent.right = successor;
			}
		}
		
		return true;
	}// End of delete
	
	public BTNode getSuccessor(BTNode deleteNode){
		BTNode successor = null;
		BTNode successorParent = null;
		BTNode current = deleteNode.right; //Coz we are finding the successor from the right subtree
		
		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		//At this point, current == null, successor == smallest node in the right subtree
		//Check if your successor has a right subtree
		//If there is, add the successor's right child to successor's left child
		if (successor!=deleteNode.right){
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		
		return successor;
	}
	
	public void display(BTNode root){
		if(root!=null){
			display(root.left);
			System.out.println(" " + root.data);
			display(root.right);
		}
	}
	
	
}
