import java.util.Scanner;
public class SinglyLinkedList {
  public static void main(String[] args) {
    List l = new List();
    Scanner sc = new Scanner(System.in);
    String str;
    String str1;
    int n;
    List l1;
    String choice;
    do {
      System.out.println("enter your choice:");
      choice = sc.next();
      switch(choice) {
        case "insertElement": 
          str = sc.next();
          l.insertElement(Integer.parseInt(str));
          break;
        case "insertAfter":
          System.out.println("Enter element");
          str = sc.next();
          System.out.println("Enter value to be inserted");
          str1 = sc.next();
          l.insertAfter(Integer.parseInt(str),Integer.parseInt(str1));
          break;
        case "insertBefore":
          System.out.println("Enter element");
          str = sc.next();
          System.out.println("Enter value to be inserted");
          str1 = sc.next();
          l.insertBefore(Integer.parseInt(str),Integer.parseInt(str1));
          break;
        case "removeAtIndex":
          str = sc.next();
          l.removeAtIndex(Integer.parseInt(str));
          break;
        case "removeElement":
          str = sc.next();
          l.removeElement(Integer.parseInt(str));
          break;
        case "popFront":
          l.popFront();
          break;
        case "popBack":
          l.popBack();
          break;
        case "pushFront":
          str = sc.next();
          l.pushFront(Integer.parseInt(str));
          break;
        case "pushBack":
          str = sc.next();
          l.pushBack(Integer.parseInt(str));
          break;
        case "concat":
          System.out.println("Enter number of elements in the list");
          n = Integer.parseInt(sc.next());
          l1 = new List();
          for(int i = 0; i < n; i++) {
            str = sc.next();
            l1.insertElement(Integer.parseInt(str));
          }
          l.concat(l1);
          break;
        case "concatAt":
          System.out.println("Enter number of elements in the list");
          n = Integer.parseInt(sc.next());
          l1 = new List();
          for(int i = 0; i < n; i++) {
            str = sc.next();
            l1.insertElement(Integer.parseInt(str));
          }
          System.out.println("Enter index");
          str = sc.next();
          n = Integer.parseInt(str);
          l.concatAt(n,l1);
          break;
        case "makeEmpty":
          l.makeEmpty();
          break;
        case "print":
          l.print();
          break;
        case "end":
          System.out.println("End of program!!");
          break;
        default:
          System.out.println("Input is invalid");
      }
    }while(!(choice.equals("end")));
  }
}