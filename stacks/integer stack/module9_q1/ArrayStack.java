public class ArrayStack<E> implements StackADT<E> 
{
  private int top;
  private E[] stack;
  private int size;

  public ArrayStack() 
  {
    top = -1;
    size = 10;
    stack = (E[]) new Object[size];
  }

  public ArrayStack(int size) 
  {
    this.size = size;
    stack = (E[]) new Object[size];
    top = -1;
  }

  public void push(E element) 
  {
    if(top == size - 1) 
    {
      System.out.println("Overflow");
    } 
    else 
    {
      top++;
      stack[top] = element;
    }
  }

  public void pop() 
  {
    if(top != -1) 
    {
      top--;
    } 
    else 
    {
      System.out.println("Underflow");
    }
  }
  
  public int getTop() 
  {
    return top;
  }
  public void display() 
  {
    for(int i = top; i >= 0; i--)
      System.out.println(stack[i] + " ");
  }
}