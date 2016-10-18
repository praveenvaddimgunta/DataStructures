public class Node<E> 
{
  private E data;
  private Node link;
  public Node(E element) 
  {
    data = element;
    link = null;
  }
  public void setData(E element) 
  {
    this.data = element;
  }
  public void setLink(Node n) 
  {
    link = n;
  }
  public E getData() 
  {
    return data;
  }
  public Node getLink() 
  {
    return link;
  }
}

