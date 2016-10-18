import java.util.Scanner;

public class BalancedExpression 
{
    public static void main(String[] args) 
    {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int length = s.length();
    char[] array = new char[length];
    int top = -1;
    for(int i = 0; i < length; i++) 
    {
      if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        top++;
        array[top] = s.charAt(i);
      }
       else if (s.charAt(i) == ')') 
       {
        if(top != -1) 
        {
          if(array[top] == '(') 
          {
            top--;
          }
        } 
        else 
        {
          System.out.println("Unbalanced Expression");
          return;
        }
      } 
      else if(s.charAt(i) == '}') 
      {
        if(top != -1) 
        {
          if(array[top] == '{') 
          {
            top--;
          }
        } 
        else 
        {
          System.out.println("Unbalanced Expression");
          return;
        }
      } 
      else if(s.charAt(i) == ']') 
      {
        if(top != -1) 
        {
          if(array[top] == '[') 
          {
            top--;
          }
        } 
        else 
        {
          System.out.println("Unbalanced Expression");
          return;
        }
      } 
      else 
      {
        System.out.println("Invalid Input");
        return;
      }
    }
    if(top != -1)
      System.out.println("Unbalanced Expression");
    else
      System.out.println("Balanced Expression");  
  }
}