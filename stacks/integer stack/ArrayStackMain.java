import java.util.*;
public class ArrayStackMain 
{
  public static void main(String[] args) 
  {
    ArrayStack<Integer> array = new ArrayStack<Integer>();
    Scanner sc = new Scanner(System.in);
    String choice;
    do 
    {
      System.out.println("Enter your choice\nPush\nPop\ngetTop\ndisplay\nend");
      choice = sc.next();
      switch(choice) 
      {
        case "push":
          System.out.println("Enter element");
          array.push(Integer.parseInt(sc.next()));
          break;
        case "pop":
          array.pop();
          break;
        case "getTop":
          System.out.println("Top : " + array.getTop());
          break;
        case "display":
          array.display();
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