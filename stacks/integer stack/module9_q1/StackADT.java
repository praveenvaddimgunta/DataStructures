public interface StackADT<E>
{
  public void push(E element);
  public void pop();
  public int getTop();
  public void display();
}