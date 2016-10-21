import java.util.*;
class DFSMain
{
  public static void main(String[] args) {
    int j=0,k =0;
    Scanner sc = new Scanner(System.in);
    int node= Integer.parseInt(sc.nextLine());
    int type= Integer.parseInt(sc.nextLine());
    int array[][]=new int[node+1][node+1];
    DFSMethods object=new DFSMethods(node);
    if(type==1) {
      for(int i=1;i<=node;i++) {
        for(j=1;j<=node;j++) {
          array[i][j] = Integer.parseInt(sc.next());
        }
      }
      object.dfs(array);
      object.print();  
    } else if(type == 0) {
      for( int i=0; i<node; i++) {
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str,"->");
        boolean flag = false;
        while (st.hasMoreTokens()) {
          if(flag == false) {
            j = (Integer.parseInt(st.nextToken()));
            flag = true;
          } if(flag == true) {
            k = (Integer.parseInt(st.nextToken()));
          }
          array[j][k] = 1;
        }
      }
      object.dfs(array);
      object.print();      
    } else {
      System.out.println("Invalid input");
    }
  }
}
class Stack 
{
  private int[] stackArray;
  private int count;
  private int top;
  public Stack() 
  {
    count=100;
    top=-1;
    stackArray = new int[count];
  }
  public void push(int value) 
  {
    if(top == count-1) {
    }
    else 
    {
      top++;
      stackArray[top] = value;
    }
  }
  public void pop() {
    if(isEmpty()) {
    }
    else {
      top--;
    }
  }
  public boolean isEmpty() {
    return (top == -1);
  }
  public int top(){
    return stackArray[top];
  }
}
class DFSMethods {
  private int[] wasVisited;
  private int[] traverse;
  private int size;
  public DFSMethods(int num) {
    wasVisited = new int[num + 1];
    traverse = new int [num];
    this.size = num ;
  }
  public void dfs(int[][] array) {
    Stack stack = new Stack();//creating obj for stack class
    int val = 0;
    int i = 1;
    traverse[val++] = i;
    wasVisited[i] = 1;//marking the wasVisited nodes
    stack.push(i);//pushing initial element into stack
    while(!stack.isEmpty()) {
      i = stack.top();//checking the top most element
      int j = i;
      while(j <= size) {
        if(array[i][j] == 1 && wasVisited[j] == 0) {
          stack.push(j);//pushing the next traversed elements
          wasVisited[j] = 1;
          i = j; j = 1;
          traverse[val++] = i;//adding the traversed path elements to array
          continue;
        }
        j++;
      }
      stack.pop();//poping out the traversed element
    }
  }
  public void print() {
    for(int i = 0 ; i < size ; i++) {
      System.out.print(traverse[i] + " ");
    }
  }
}
