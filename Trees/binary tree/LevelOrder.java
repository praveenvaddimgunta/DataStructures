import java.util.*;
class Node {
  private int data;
  private Node left;
  private Node right;
    
  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
  public void setData(int data) {
    this.data = data;
  }
  public void setLeft(Node link) {
    this.left = link;
  }
  public void setRight(Node link) {
    this.right = link;
  }
  public int getData() {
    return data;
  }
  public Node getLeft() {
    return left;
  }
  public Node getRight() {
    return right;
  }
}

class Tree {
  ArrayList<Node> list;
  Node root;
  Tree() {
    list = new ArrayList<Node>();
    root = null;
  }
  public void insert(int element) {
    if(root == null) {
      root = new Node(element);
      return;
    }
    Node temp = root;
    Node n = new Node(element);
    list.add(n);
    for(int i = 0; i < list.size(); i++) {
      temp = list.get(i);
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

  public void traversal() {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    while(!q.isEmpty()) {
      Node temp = q.poll();
      System.out.print(temp.getData() + " ");
      if(temp.getLeft() != null)
        q.add(temp.getLeft());
      if(temp.getRight() != null)
        q.add(temp.getLeft());
    }
  }
}
public class LevelOrder {
  public static void main(String[] args) {
    Tree t = new Tree();
    t.insert(1);
    t.insert(5);
    t.insert(2);
    t.insert(9);
    t.insert(3);
    t.traversal();
  }
}