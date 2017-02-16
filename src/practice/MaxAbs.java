package practice;

public class MaxAbs {

	public static void main(String[] args) {
		Node rootNode = new Node(10);
		Node leftNode = new Node(-10);
		Node rightNode = new Node(20);
		
		rootNode.leftChild = leftNode;
		rootNode.rightChild = rightNode;

		int result = findMaxAbs(rootNode);
		System.out.println(result);
	}
	
	/**
	 * Find the node with minimum value and the node with maximum value by inorder traversal through the tree, 
	 * then calculate the absolute value of their difference.
	 * @param rootNode
	 * @return the maximum absolute value
	 */
	public static int findMaxAbs(Node rootNode){
		Node minNode = new Node(rootNode);
		Node maxNode = new Node(rootNode);
		inOrderVisit(rootNode, minNode, maxNode);
		return maxNode.value - minNode.value;
	}
	
	public static void inOrderVisit(Node curNode, Node minNode, Node maxNode){
		if (curNode == null) return;
		
		inOrderVisit(curNode.leftChild, minNode, maxNode);
		
		if (curNode.value < minNode.value)
			minNode.value = curNode.value;
		if (curNode.value > maxNode.value)
			maxNode.value = curNode.value;

		inOrderVisit(curNode.rightChild, minNode, maxNode);
	}
	
}

class Node {
	Node leftChild;
	Node rightChild;
	int value;
	
	Node(int value){
		this.value = value;
	}
	
	Node(Node node){
		this.value = node.value;
	}
}
