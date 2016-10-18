public class Node {
  private int data;
  private Node link;

  public Node() {
    data = 0;
    link = null;
  }

  public Node(int d, Node n) {
    data = d;
    link = n;
  }

  public void setLink(Node n) {
    link = n;
  }

  public Node getLink() {
    return link;
  }

  public void setData(int d) {
    data = d;
  }

  public int getData() {
    return data;
  }
}
