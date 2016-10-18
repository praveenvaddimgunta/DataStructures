import java.util.Scanner;

public class LinkedListMain 
{
  public static void main(String[] args) 
  {
    LinkedList<Integer> list = new LinkedList<Integer>();
    Scanner sc = new Scanner(System.in);
    String choice;
    do 
    {
      System.out.println("Enter your choice \npush\npop\ngetTop\ndisplay\nend");
      choice = sc.next();
      switch(choice) 
      {
        case "push":
          System.out.println("Enter element");
          list.push(Integer.parseInt(sc.next()));
          break;
        case "pop":
          list.pop();
          break;
        case "getTop":
          System.out.println("Top : " + list.getTop());
          break;
        case "display":
          list.display();
          break;
        case "end":
          System.out.println("End of program!!");
          break;
        default:
          System.out.println("Invalid input");
      }
    } while(!(choice.equals("end")));
  }
}