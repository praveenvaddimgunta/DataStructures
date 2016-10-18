import java.util.*;

public class ListQueueMain
{
  public static void main(String[] args) 
  {
    ListQueue<Integer> queue = new ListQueue<Integer>();
    String choice;
    Scanner sc = new Scanner(System.in);
    do 
    {
        System.out.println("Enter your choice\nenqueue\ndequeue\ngetFront\nclear\nprint\nend");
        choice = sc.next();
        switch(choice) 
        {
          case "enqueue":
            System.out.println("Enter element");
            int n = Integer.parseInt(sc.next());
            queue.enqueue(n);
            break;
          case "dequeue":
            System.out.println("Element dequeued:" + queue.dequeue());
            break;
          case "getFront":
            System.out.println(queue.getFront());
            break;
          case "clear":
            queue.clear();
            break;
          case "print":
            queue.print();
            break;
          case "end":
            System.out.println("End of program!!");
            break;
          default: 
            System.out.println("Input is invalid");
        }
      } while(!(choice.equals("end")));
  }
}