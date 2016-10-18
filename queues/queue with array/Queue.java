import java.util.Scanner;
public class Queue 
{
  public static void main(String[] args) 
  {
      ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
      int in;
      Scanner sc = new Scanner(System.in);
      do 
      {
        System.out.println("1.Enqueue 2.Dequeue 3.Get Front 4.Clear 5.Exit");
        in = Integer.parseInt(sc.next());
        switch(in) 
        {
          case 1:
            System.out.println("Enter element");
            int n = Integer.parseInt(sc.next());
            queue.enqueue(n);
            break;
          case 2:
            System.out.println("Element dequeued:" + queue.dequeue());
            break;
          case 3:
            System.out.println(queue.getFront());
            break;
          case 4:
            queue.clear();
            break;
          case 5:
            System.out.println("End of program!!");
            break;
          default: 
            System.out.println("Input is invalid");
        }
      } while(in != 5);
    }  
}