public class ListQueue<E> implements QueueADT<E> 
{
  Node front;
  Node rear;
  int count;
  public ListQueue() 
  {
    front = null;
    rear = null;
    count = 0;
  }
  public void enqueue(E element) 
  {
    if(isEmpty()) 
    {
      Node n = new Node(element);
      front = n;
      rear = n;
      count++;
    } 
    else 
    {
      Node n = new Node(element);
      rear.setLink(n);
      rear = n;
      count++;
    }
  }
  public E dequeue() 
  {
    E data;
    if(count == 1) 
    {
      data = (E)front.getData();
      front = null;
      rear = null;
      count = 0;
      return data; 
    }
    else if(count != 0) 
    {
      data = (E)front.getData();
      Node n = front.getLink();
      front = n;
      count--;
      return data;      
    } 
    else 
    {
      System.out.println("Empty Queue");
      return null;
    }
  }
  public E getFront() 
  {
    if(count != 0) 
    {
      Node n = front;
      E data = (E)n.getData();
      return data;
    }
    else
      return null;
  }
  public boolean isEmpty() 
  {
    if(count == 0)
      return true;
    else
      return false;
  }
  public void clear() 
  {
    front = null;
    rear = null;
    count = 0;
  }
  public void print() 
  {
    Node temp = front;
    if(count==0)
      System.out.println("Queue is empty");
    else
    {
    for(int i = 0; i < count; i++) 
    {
      System.out.println(temp.getData());
      temp = temp.getLink();
    }
  }
  }
}
