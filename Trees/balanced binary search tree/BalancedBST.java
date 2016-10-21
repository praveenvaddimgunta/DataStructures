class Node {
	Node left;
	Node right;
	int data;

	public Node() {
		left = null;
		right = null;
		data =0;
	}
	public Node(int n) {
		left = null;
		right = null;
		data = n;
	}
	public void setLeft(Node n) {
		left = n;
	}
	public void setRight(Node n) {
		right = n;
	}
	public void setData(int d) {
		data = d;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public int getData() {
		return data;
	}
}

class BST {
	Node root;

	public BST() {
		root = null;
	}
	public boolean isEmpty() {
		if (root == null)
			return true;
		else 
			return false;
	}
	public void insert(int data) {
		root = insert(root,data);
	}
	public Node insert(Node root, int data) {
		if (root == null)
			root = new Node(data);
		else
		{
			if(data <= root.getData())
				root.left = insert(root.left, data);
			else
				root.right = insert(root.right, data);
		}
		return root;
	}
}