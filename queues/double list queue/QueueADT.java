public interface QueueADT<E> 
{
  public void enqueue(E element);
  public E dequeue();
  public E getFront();
  public boolean isEmpty();
  public void clear();
  public void print();
}