import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
class Node {
  private int data;
  private Node left;
  private Node right;
  
  public Node() {
    left = null;
    right = null;
  }
  public Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
  public void setData(int data) {
    this.data = data;
  }
  public void setRight(Node n) {
    this.right = n;
  }
  public void setLeft(Node n) {
    this.left = n;
  }
  public int getData() {
    return data;
  }
  public Node getRight() {
    return right;
  }
  public Node getLeft() {
    return left;
  }
}

class BST {
  Node root;
  int count;
  int prev;
  ArrayList<Integer> arr;

  public BST(){
    root = null;
    count = 0;
  }

  public int getCount() {
    return count;
  }

  public void insert(int element) {
    root = insert(root,element);
  }

  public Node insert(Node n, int element) {
    if(n == null) {
      n = new Node(element);
    } else {
      if(n.getData() > element) {
        n.setLeft(insert(n.getLeft(),element));
      } else {
        n.setRight(insert(n.getRight(),element));
      }
    }
    return n;
  }


  public Node max(Node n) {
    if(n == null)
      return null;
    while(n.getRight() != null) {
      n = n.getRight();
    }
    return n;
  }

  public Node min(Node n) {
    if(n == null)
      return null;
    while(n.getLeft() != null)
      n = n.getLeft();
    return n;
  }

    public void remove(int element) {
    root = remove(root,element);
  }

  public Node remove(Node n, int element) {
    Node temp;
    if(n == null) {
      return n;
    } else if (element < n.getData()) {
      n.setLeft(remove(n.getLeft(),element));
    } else if(element > n.getData()) {
      n.setRight(remove(n.getRight(),element));
    } else {
      if(n.getLeft() == null && n.getRight() == null) {
        return null;        
      } else if (n.getRight() == null) {
        temp = max(n.getLeft());
        n.setData(temp.getData());
        n.setLeft(remove(n.getLeft(),n.getData()));
      } else if(n.getLeft() == null) {
        temp = min(n.getRight());
        n.setData(temp.getData());
        n.setRight(remove(n.getRight(),n.getData()));
      } else {
        temp = max(n.getLeft());
        n.setData(temp.getData());
        n.setLeft(remove(n.getLeft(),n.getData()));
      }
    }
    return n;
  }

  public boolean search(int element) {
    count = 0;
    prev = 0;
    boolean flag;
    flag = search(root,element);
    return flag;
  }

  public boolean search(Node n, int element) {
    boolean flag = false;
    while((n != null) && (!flag)) {
      int val = n.getData();
      if(element < val) {
        prev = val;
        n = n.getLeft();
        if(n==null) {
          return false;
        }
      } else if(element > val) {
        n = n.getRight();
        if(n==null) {
          return false;
        }
      } else {
        flag = true;
        return flag;
      }
      count++;
      return search(n, element);
    }
    return flag;
  }

  public int getprev() {
    return prev;
  }

  public void inorder() {
    arr = new ArrayList<Integer>();
    inorder(root);
    int i;
    for(i = 0; i < arr.size() - 1; i++) {
      System.out.print(arr.get(i) + ",");
    }
    System.out.print(arr.get(i));
  }

  public void inorder(Node n) {
    if(n != null) {
      inorder(n.getLeft());
      arr.add(n.getData());
      inorder(n.getRight());
    }
  }

  public void postorder() {
    arr = new ArrayList<Integer>();
    postorder(root);
    int i;
    for(i = 0; i < arr.size() - 1; i++) {
      System.out.print(arr.get(i) + ",");
    }
    System.out.print(arr.get(i));
  }

  public void postorder(Node n) {
    if(n!=null) {
      postorder(n.getLeft());
      postorder(n.getRight());
      arr.add(n.getData());
    }
  }
}

public class BinarySearchTree {
  public static void main(String[] args) {
    BST bst = new BST();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    StringTokenizer st = new StringTokenizer(str,", ");
    String in;
    while(st.hasMoreTokens()){
      in = st.nextToken();
      switch(in.charAt(0)) {
        case 'I' :
          try {
            bst.insert(Integer.parseInt(st.nextToken()));
            bst.inorder();
          } catch(Exception e) {
            System.out.println(0);
          }
          System.out.println();
          break;
        case 'S' :
          try {
            boolean  flag = bst.search(Integer.parseInt(st.nextToken()));
            if(flag == true) 
              System.out.println(flag + ","+ (bst.getCount() + 1));
            else
              System.out.println(flag + ","+bst.getprev());
          }catch(Exception e) {
            System.out.println(0);
          }
            break;
        case 'R' :
          try {
            bst.remove(Integer.parseInt(st.nextToken()));
            bst.postorder();
          } catch(Exception e) {
            System.out.println(0);
          }
          System.out.println();
          break;
      }
    }
  }
}