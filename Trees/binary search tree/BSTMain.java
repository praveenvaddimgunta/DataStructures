import java.util.*;
class Node {
  private int data;
  private Node left;
  private Node right;

  Node() {
    left = null;
    right = null;
  }

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void setLeft(Node n) {
    left = n;
  }

  public void setRight(Node n) {
    right = n;
  }

  public int getData(){
    return data;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }
}

class BST {
  Node root;
  int count;
  int previous;
  ArrayList<Integer> list;

  public BST() {
    root = null;
    count = 0;
  }
  public BST(Node root, int data) {
    this.root = root;
  }
  public int getCount() {
    return count;
  }

  public boolean isEmpty() {
   if (root == null)
    return true;
   else
    return false;
  }

  public void insert(int data) {
    //System.out.println(data);
    root = insert(root,data);
  }

  public Node insert(Node n, int data) {
    if (n==null) {
      n = new Node(data);
      //System.out.println(n);
    } else {
      if (n.getData() > data) {
      n.setLeft(insert(n.getLeft(),data));
    } else {
      n.setRight(insert(n.getRight(),data));
    }
  }
    //System.out.println(n);    
    return n;
  }
  public void remove(int data) {
  root = remove(root,data);
  }
  public Node remove(Node n, int data) {
    Node temp = null;
    if(n==null) {
     System.out.println("no elements in Tree");
    } else if(data < n.getData()) {
      n.setLeft(remove(n.getLeft(),data));
    } else if (data > n.getData()) {
      n.setRight(remove(n.getRight(),data));
    } else {
      if((n.getLeft()!=null) && (n.getRight()!=null)) {
        temp = findMax(n.getLeft());
        n.setData(temp.getRight().getData());
        n.setLeft(remove(n.getLeft(),n.getData()));
      } else {
        temp = n;
        if(n.getLeft() == null)
          n = n.getRight();
        if(n.getRight() == null)
          n = n.getLeft();
      }
    }
    return n;
  }
  
  public Node findMax(Node n) {
    if(isEmpty())
      return null;
    while(n.getRight()!=null)
      n = n.getRight();
    return n;
  }

  public Node findMin(Node n) {
    if(isEmpty())
      return null;
    while(n.getLeft()!=null)
      n = n.getLeft();
    return n;
  }

  public boolean find(int data) {
   count = 0;
   previous =0;
   boolean flag;
   flag = find(root,data);
   return flag; 
  }
  public boolean find(Node n, int data) {
    boolean flag = false;
    int value;
    while(n!=null) {
      value = n.getData();
      if(data < value) {
        previous = value;
        n = n.getLeft();
        if(n==null) 
          return false;
      }else if (data>value) {
        n = n.getRight();
        if (n==null) {
          return false;
        } else {
          flag = true;
          return flag;
        } 
      }
    count++;
    return find(n.getData());
    }
    return flag;
  }

  public int getPrevious() {
    return previous;
  }
  public void inorder() {
    int i;
    list = new ArrayList<Integer>();
    inorder(root);
    for(i = 0;i < list.size()-1; i++) {
      System.out.print(list.get(i)+",");
    }
    System.out.print(list.get(i));
  }
  public void inorder(Node n) {
    if(n != null) {
      inorder(n.getLeft());
      list.add(n.getData());
      inorder(n.getRight());
    }
  }
  public void postorder() {
    int i;
    list = new ArrayList<Integer>();
    postorder(root);
    for(i = 0; i<list.size()-1;i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.print(list.get(i));
  }
  public void postorder(Node n) {
    if(n!=null) {
      postorder(n.getLeft());
      postorder(n.getRight());
      list.add(n.getData());
    }
  }
}


public class BSTMain {
  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(2);
    tree.insert(5);
    tree.insert(10);
    tree.insert(#);
    tree.insert(25);
    tree.remove(1);
    tree.find(25);
    // Scanner sc = new Scanner(System.in);
    // String str = sc.nextLine();
    // StringTokenizer st = new StringTokenizer(str,",");
    // String input;
    // while(st.hasMoreTokens()) {
    //   input = st.nextToken();
    //   switch(input.charAt(0)) {
    //     case 'I':
    //     try {
    //       tree.insert(Integer.parseInt(st.nextToken()));
    //       tree.inorder();
    //     }catch(Exception e) {
    //       System.out.println(0);
    //     }
    //     System.out.println();
    //     break;
    //     case 's':
    //     try {
    //       boolean flag = tree.find(Integer.parseInt(st.nextToken()));
    //       if(flag==true)
    //         System.out.println(flag+","+tree.getCount()+1);
    //       else
    //         System.out.println(flag+","+tree.getPrevious());
    //     } catch(Exception e) {
    //       System.out.println(0);
    //     }
    //     break;
    //     case 'R':
    //     try {
    //       tree.remove(Integer.parseInt(st.nextToken()));
    //       tree.postorder();
    //     } catch(Exception e) {
    //       System.out.println(0);
    //     }
    //     System.out.println();
    //     break;
    //   }
    // }
  }
}