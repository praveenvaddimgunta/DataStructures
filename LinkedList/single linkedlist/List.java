public class List {
  private Node start;
  private Node end;
  private int count;
  
  public List() {
    start = null;
    end = null;
    count = 0;
  }
  
  public void insertElement(int i){
    Node n = new Node(i, null);
    if(start == null) {
      start = n;
      end = start;
    } else {
      end.setLink(n);
      end = n;
    }
    count ++;
  }

  public void insertAfter(int element, int data) {
    Node n = new Node(data, null);
    Node ptr = start;
    int i;
    for(i = 0; i < count; i++) {
      if(ptr.getData() == element) {
        Node temp = ptr.getLink();
        ptr.setLink(n);
        n.setLink(temp);
        count++;
        break;
      } else {
        ptr = ptr.getLink();
      }
    }
    if(i == count){
      System.out.println("Element not found");
    }
  }

  public void insertBefore(int element, int data) {
    Node n = new Node(data, null);
    Node ptr = start;
    Node temp = start;
    int i;
    for(i = 0; i < count; i++) {
      if(ptr.getData() == element) {
        temp.setLink(n);
        n.setLink(ptr);
        count++;
        break;
      }
      temp = ptr;
      ptr = ptr.getLink();
    }
    if(i == count){
      System.out.println("Element not found");
    }
  }

  public void removeAtIndex(int index) {
    if(index > count) {
      System.out.println("Index out of range");
      return;
    } else if(index == 0) {
      start = start.getLink();
      count--;
    } else if(index == (count - 1)) {
      Node s = start;
      Node e = end;
      while(s != end) {
        e = s;
        s = s.getLink();
      }
      end = e;
      end.setLink(null);
      count --;
    } else {
      Node ptr = start;
      for(int i = 1; i < count; i++) {
        if(i == index) {
          Node temp = ptr.getLink();
          temp = temp.getLink();
          ptr.setLink(temp);
          count--;
          break;
        }
        ptr = ptr.getLink();
      }
    }
  }

  public void removeElement(int element) {
    Node ptr = start;
    int i;
    if(ptr.getData() == element){
      popFront();
    }
    else if(end.getData() == element){
      popBack();
    } else {
      Node temp = start;
      ptr = start.getLink();
      for(i = 1; i < count; i++) {
        if(ptr.getData() == element) {
          ptr = ptr.getLink();
          temp.setLink(ptr);
          count--;
          break;
        }
        temp = ptr;
        ptr = ptr.getLink();
      }
      if(i==count)
        System.out.println("Element not found");
    }
  }

  public void popFront() {

    if(count == 1 || count == 0) {
      start = null;
      end = null;
      count = 0;
    } else {
      start = start.getLink();
      count--;
    }
  }

  public void popBack() {
    if(count == 1 || count == 0) {
      start = null;
      end = null;
      count = 0;
    } else { 
      Node s = start;
      Node e = end;
      while(s != end) {
        e = s;
        s = s.getLink();
      }
      end = e;
      end.setLink(null);
      count--;
    }
  }

  public void pushFront(int i) {
    Node n = new Node(i,null);
    n.setLink(start);
    start = n;
    count++;
  }

  public void pushBack(int i) {
    Node n = new Node(i,null);
    end.setLink(n);
    end = n;
    count++;
  }

  public void concat(List l) {
    if(count != 0) {
      end.setLink(l.start);
      end = l.end;
      count = count + l.count;
    } else {
      System.out.println("List is empty, cannot concatenate");
      return;
    }
  }

  public void concatAt(int index, List l) {
    if(count != 0) {
      Node temp = start;
      if(index > count) {
        System.out.println("Index out of range");
        return;
      }
      for(int i = 0; i < index - 1; i++) {
        temp = temp.getLink();
      }
      Node ptr = temp.getLink();
      Node temp1 = l.start;
      temp.setLink(temp1);
      while(temp1.getLink() != null) {
        temp1 = temp1.getLink();
      }
      temp1.setLink(ptr);
      count = count+l.count;
    } else {
      System.out.println("List is empty, cannot concatenate");
      return;
    }
  }

  public void makeEmpty() {
    start = null;
    end = null;
    count = 0;
  }

  public void print() {
    Node ptr = start;
    if(count == 0) {
      System.out.println("List is empty");
      return;
    }
    for(int i = 0; i < count - 1; i++) {
      System.out.print(ptr.getData() + "->");
      ptr = ptr.getLink();
    }
    System.out.println(ptr.getData());
  }
}
