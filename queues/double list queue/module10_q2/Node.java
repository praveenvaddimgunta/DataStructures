public class Node<E>
{
  E data;
  Node previous;
  Node next;
  public Node(E element) 
  {
    data = element;
    previous = null;
    next = null;
  }
  public void setData(E element) 
  {
    this.data = element;
  }
  public void setPrevious(Node n) 
  {
    previous = n;
  }
  public void setNext(Node n) 
  {
    next = n;
  }
  public E getData() 
  {
    return data;
  }
  public Node getPrevious() 
  {
    return previous;
  }
  public Node getNext() 
  {
    return next;
  }
}
