@SuppressWarnings("unchecked")
class MinHeap<E extends Comparable<E>> {
  E[] heap;
  int size;
  public MinHeap() 
  {
    heap = (E[])new Comparable[20];
    size = 0;
  }

  public void swap(int i , int j) 
  {
    E temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public void bubbleUp() 
  {
    int i = size;
    int j = i/2;
    E temp;
    while(j > 0) 
    {
      if(heap[i].compareTo(heap[j]) < 0) 
      {
        swap(i,j);
        i = j; 
        j = i/2;
      } 
      else 
      {
        break;
      }
    }
  }

  public void bubbleDown() 
  {
    int i = 1;
    int j = 2*i;
    E temp;
    while(j <= size) 
    {
      if(heap[i].compareTo(heap[j]) > 0) 
      {
        swap(i,j);
        i = j;
        j = 2*i;
      } 
      else if(heap[i].compareTo(heap[j + 1]) > 0) 
      {
        swap(i,j+1);
        i = j + 1;
        j = 2 * i;
      } 
      else
      {
        break;
      }
    }
  }
  public void insert(E element)
  {
    size++;
    heap[size] = element;
    bubbleUp();
  }
  public E extractMin() 
  {
    return heap[1];
  }
  public void deleteMin() 
  {
    heap[1] = heap[size];
    size--;
    bubbleDown();
  }
  
  public void print() 
  {
    for(int i = 1; i < size + 1; i++) 
    {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }
}
public class BinaryHeap 
{
  public static void main(String[] args) 
  {
    MinHeap<Integer> obj = new MinHeap<Integer>();
    obj.insert(10);
    obj.insert(20);
    obj.insert(30);
    obj.insert(15);
    obj.insert(1);
    obj.print();
    obj.deleteMin();
    obj.print();
  }
}