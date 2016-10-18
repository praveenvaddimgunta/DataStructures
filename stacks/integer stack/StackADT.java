public interface StackADT<E>
{
  public void push(E element);
  public void pop();
  public E getTop();
  public void display();
}