import java.util.*;
class Node<E> {
  private E data;
  private Node left;
  private Node right;

  Node() {
    left = null;
    right = null;
  }

  Node(E data) {
    this.data = data;
    left = null;
    right = null;
  }

  public void setData(E data) {
    this.data = data;
  }

  public void setLeft(Node n) {
    left = n;
  }

  public void setRight(Node n) {
    right = n;
  }

  public E getData(){
    return data;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }
}

class Tree<E> {
  Node root;
  int count;
  ArrayList<Node> arr = new ArrayList<Node>();
  public Tree() {
    root = null;
    count = 0;
  }

  public void insert(E element) {
    if(root == null) {
      root = new Node(element);
      arr.add(root);
      return;
    }
    Node temp = root;
    Node n = new Node(element);
    arr.add(n);
    for(int i = 0; i < arr.size(); i++) {
      temp = arr.get(i);
      if(temp.getLeft() == null) {
        temp.setLeft(n);
        return;
      }
      if(temp.getRight() == null) {
        temp.setRight(n);
        return;
      }
    }
  }

  public void inorder() {
    inorder(root);
  }
  public void inorder(Node n) {
  	if(n==null)
  		return;
  	//System.out.println(n.getLeft().getData());
    inorder(n.getLeft());
    System.out.println(n.getData());
    inorder(n.getRight());
  }
  public void preorder() {
    preorder(root);
  }
  public void preorder(Node n) {
  	if(n==null)
  		return;
    System.out.println(n.getData());
    preorder(n.getLeft());
    preorder(n.getRight());
  }
  public void postorder() {
    postorder(root);
  }
  public void postorder(Node n) {
  	if(n==null)
  		return;
    postorder(n.getLeft());
    postorder(n.getRight());
    System.out.println(n.getData());
  }
}

public class BinaryTree {
  public static void main(String[] args) {
    Tree<Integer> tree = new Tree<Integer>();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    //tree.inorder();
    //tree.preorder();
    tree.postorder();
  }

}