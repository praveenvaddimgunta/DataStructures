public class DoubleListQueue<E> implements QueueADT<E> 
{
  Node front;
  Node rear;
  int count;

  public DoubleListQueue() 
  {
    front = null;
    rear = null;
    count = 0;
  }
  public void enqueue(E element) 
  {
    Node n = new Node(element);
    if(isEmpty()){
      front = n;
      rear = n;
      count++;
    } 
    else 
    {
      n.setPrevious(rear);
      rear.setNext(n);
      rear = n;
      count++;
    }
  }
  public E dequeue() 
  {
    E data = (E)front.getData();
    front = front.getNext();
    front.setPrevious(null);
    count--;
    return data;
  }
  public E getFront() 
  {
    E data = (E) front.getData();
    return data;
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
    for(int i = 0; i < count; i++) 
    {
      System.out.print(temp.getData());
      temp = temp.getNext();
    }
  }
}
