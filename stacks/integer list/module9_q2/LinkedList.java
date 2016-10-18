public class LinkedList<E> implements StackADT<E> 
{
  private int top;
  private Node head;
  public LinkedList()
  {
    top = -1;
    head = null;
  }
  public void push(E element) 
  {
    Node n = new Node(element);
    n.setLink(head);
    head = n;
    top++;
  }
  public void pop() 
  {
    if(top != -1) 
    {
      Node n = head.getLink();
      head = n;
      top--;
    } 
    else 
    {
      System.out.println("List is empty");
    }
  }
  public int getTop()
  {
    return top;
  }
  public void display()
  {
    Node temp = head;
    for(int i = top; i >= 0; i--) 
    {
      System.out.println(temp.getData());
      temp = temp.getLink();
    }
  }
}