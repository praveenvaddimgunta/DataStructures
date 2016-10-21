import java.util.*;
@SuppressWarnings("unchecked")
class BinaryHeap<T extends Comparable<T>>
{
  private T[] heap;
  private int count;
  BinaryHeap()
  {
    heap = (T[])new Comparable[20];
    count = 1;
  }
  public void insert(T element)
  {
    heap[count] = element;
    if(count >= 2)
      bubbleUp(count);
    count++;
    for(int i=1; i<count;i++)
    {
      System.out.print(heap[i]+" ");
    }
    System.out.println();
  }
  public T extract_min()
  {
    return heap[1];
  }
  public void delete_min()
  {
    count--;
    heap[1] = heap[count];
    bubbleDown();
    for(int i=1; i<count;i++)
    {
      System.out.print(heap[i]+" ");
    }
    System.out.println();
  }
  private void bubbleUp(int lastIndex)
  {
    int temp = lastIndex;
    while(temp != 1)
    {
      int parent = temp/2;
      if(heap[parent].compareTo(heap[temp])>0)
      {
        T temp1 = heap[parent];
        heap[parent] = heap[temp];
        heap[temp] = temp1;
      }
      temp = parent;
    }
  }
  private void bubbleDown()
  {
    int parent = 1;
    int left = 2;
    int right = 3;
    while(left < count)
    {
      int index = left;
      if(right < count)
      {
        if(heap[left].compareTo(heap[right]) > 0)
        {
          index = right;
        }
      }
      if(heap[index].compareTo(heap[parent])<0)
      {
        swap(parent , index);
        parent = index;
        left = parent*2;
        right = left+1;
      }
      else
        break;
    }
  }
  public void swap(int parent , int index) {
    T temp = heap[parent];
        heap[parent] = heap[index];
        heap[index] = temp;
  }
  public void modify(int index, T value)
  {
    
    if(value.compareTo(heap[index])>0)
    {
      heap[index] = value;
      bubbleDown();
    }
    else
    {
      heap[index] = value;
      bubbleUp(index);
    }
    for(int i=1; i<count;i++)
    {
      System.out.print(heap[i]+" ");
    }
    System.out.println();
  }
  public void printArr()
  {
    for(int i=1;i<count;i++)
    {
      System.out.println(heap[i]);
    }
  }
}

public class BinaryHeapMain
{
  public static void main(String args[])
  {
    BinaryHeap<Integer> bh = new BinaryHeap<Integer>();
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    int val1 = 0 , val2 = 0;
    StringTokenizer st = new StringTokenizer(line, " ,");
    while(st.hasMoreTokens())
    {
      String each = st.nextToken();
      if(each.equals("i"))
      {
        val1 = Integer.parseInt(st.nextToken());
        bh.insert(val1);
      }
      if(each.equals("mo"))
      {
        val1 = Integer.parseInt(st.nextToken());
        val2 = Integer.parseInt(st.nextToken());
        bh.modify(val1,val2);
      }
      if(each.equals("d"))
      {
        bh.delete_min();
      }
      if(each.equals("end"))
        break;
    }
  }
}