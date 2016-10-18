public class ArrayQueue<E> implements QueueADT<E> 
{
  int front;
  int rear;
  E[] que;
  int size;
  int count;

  ArrayQueue() 
  {
    size = 10;
    front = 0;
    rear = -1;
    que = (E[])new Object[size];
    count = 0;
  }

  ArrayQueue(int size) 
  {
    this.size = size;
    front = 0;
    rear = -1;
    count = 0;
    que = (E[])new Object[size];
  }

  public void enqueue(E element) 
  {
    if(front == 0 && rear == size - 1) 
    {
      System.out.println("Queue is full");
      return;
    }
    else if(rear == size - 1 && front != 0) 
    {
      rear = 0;
      que[rear] = element;
      count++;
    } 
    else 
    {
      rear++;
      que[rear] = element;
      count++;
    }
  }
    public E dequeue() 
    {
    E n = que[front];
    front++;
    count--;
    if(isEmpty()) 
    {
      front = 0;
      rear = -1;
      count = 0; 
    }
    return n;
  }
  
  public E getFront()
  {
    if(count != 0)
      return que[front];
    else 
    {
      System.out.println("Empty Queue");
      return null;
    }
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
    front = 0;
    rear = -1;
    count = 0;
  }
}

