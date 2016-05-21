/**
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 237: Delete Node in a Linked List
 * 
 * Here I actually build the Node class and the Linked List and show how to search the
 * target value and delete the node. Result are print through the print function.
 * }
 */
public class deleteNodeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node firstNode = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		Node forthNode = new Node(4);
		
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = forthNode;
		
		
		System.out.println("Before delete");
		System.out.println(print(firstNode));
		delete(firstNode, 3);
		System.out.println("After delete Node 3");
		System.out.println(print(firstNode));
	}
	
	public static void delete(Node currentNode, int target){
		//Search for the target Node
		while (currentNode.val != target){
			currentNode = currentNode.next;
		}
		
		//When your program run to this point. You should have currentNode.value == target
		currentNode.val = currentNode.next.val;
		currentNode.next = currentNode.next.next;
	}
	
	public static String print(Node n){
		String result = "";
		while (n != null){
			result += n.val + " ";
			n = n.next;
			
		}
		return result;
	}

}

class Node{
	int val;
	Node next;
	//Constructor
	public Node(int d){
		val = d;
	}
}
