import java.util.StringTokenizer;
import java.util.Scanner;
public class BFSParent {
 public static void main( String[] args) {
     Scanner scan = new Scanner(System.in);
     String string;
     int verticeCount;
     int vertice,rootVertice;
     verticeCount = Integer.parseInt(scan.nextLine());
     Graph graphObject = new Graph(verticeCount);
     for(int i =0;i< verticeCount;i ++) {
     graphObject.addVertex(i+1);
     }
     //System.out.println("chooseFormat");
     int format = Integer.parseInt(scan.nextLine());
   switch(format) {
     case 0 :
       for(int i = 0; i < verticeCount; i++ ) {
           //System.out.println("*************");
         string = scan.nextLine();
     //    System.out.println(string);
         StringTokenizer str = new StringTokenizer(string,"->");
         rootVertice = Integer.parseInt(str.nextToken());
         while(str.hasMoreTokens()) {
             vertice =Integer.parseInt(str.nextToken());
             //System.out.println(rootVertice + "******" + vertice);
             graphObject.addEdge(rootVertice-1,vertice-1);
         }
       }
       graphObject.bfs();
       graphObject.printParentArray();
       break;

     case 1:
       int[][] verticeMatrix = new int[verticeCount][verticeCount];
       //System.out.println("***********");
       for(int i = 0; i < verticeCount; i++ ) {
         for(int j = 0; j < verticeCount; j++) {
             verticeMatrix[i][j] = Integer.parseInt(scan.next());
           if(verticeMatrix[i][j] == 1){
             graphObject.addEdge(i,j);
           }       
         }
       }
       
       

       graphObject.bfs();
       break;
   }
 }
}

/******************--------------vertex class ---------------********************/
class Vertex {
    public int label;
    public boolean visited;
    public Vertex(int label) {
        this.label = label;
        visited = false;
    }/*
    public void setVertex(char a) {
        this.a = a;
    }
    public void setVisited (boolean b) {
        visited = b;
    }
    public char getVertex() {
        return a;
    }
    public boolean isVisited() {
        return visited;
    }*/
}

class Graph {
 //private final int 
 private Vertex vertexArray[];
 private int adjMatrix[][];
 private int vertexCount1;
 private Queues queue;
 private Integer parentArray[];

 public Graph(int verticeCount) {
     parentArray = new Integer[verticeCount];
   vertexArray = new Vertex[verticeCount];
     adjMatrix = new int[verticeCount][verticeCount];
     vertexCount1 = 0;
     for(int i = 0; i < verticeCount; i++) {
       for(int j = 0; j < verticeCount; j++ ){
           adjMatrix[i][j] = 0;
       }
     } 
     queue = new Queues();
 }

 public void addVertex(int label) {
     vertexArray[vertexCount1++] = new Vertex(label);
 }

 public void addEdge(int i,int j) {
     adjMatrix[i][j] = 1;
     adjMatrix[j][i] = 1;
 }

 public void displayVertex(int vertex) {
     System.out.println(vertexArray[vertex].label);
 }

 public void bfs() {
     //System.out.println(vertexArray[0]);
     vertexArray[0].visited = true;
     displayVertex(0);
     queue.enqueue(0);
    int vertex2;
    //System.out.println(queue.isEmpty());
    while(!queue.isEmpty()) {
     int vertex1 = queue.dequeue();
     //System.out.println(vertex1);
     while((vertex2= getUnvisitedVertex(vertex1)) != -1) {
        vertexArray[vertex2].visited = true;
         displayVertex(vertex2);
       parentArray[vertex2] = vertex1 + 1;
         queue.enqueue(vertex2);
     }
    }
 }

 public void printParentArray() {
   for(int i = 0; i < parentArray.length; i++) {
     System.out.println(parentArray[i]);
   }
 }

 public int getUnvisitedVertex( int vertex) {
     for(int i = 0; i < vertexCount1; i++) {
       if((adjMatrix[vertex][i] == 1) && (vertexArray[i].visited == false))
           return i;
     }
     return -1;
 }
}
class Node<E> {

private int element;
private Node link;

public Node() {
  element = 0;
  link = null;

}

public Node(int element,Node link) {
  this.element = element;
  this.link = link;

}

public int getElement() {
  return element;
}

public void setElement(int element) {
  this.element = element;
}

public Node getLink() {
  return link;
}

public void setLink(Node link) {
  this.link = link;
}

}


@SuppressWarnings("unchecked")
class Queues   {
 private Node front;
  private Node rear;
  private int noofnodes;

 public Queues() {
   front = null;
   rear = null;
   noofnodes = 0;
 }

 public void enqueue(int ele) {
   Node object = new Node(ele,null);
   if(front == null) {
     front = object;
     rear = front;
     noofnodes++;
   } else {
     rear.setLink(object);
     object.setLink(null);
     rear = object;
     noofnodes++;
   }
 }

 public int dequeue() {
   int temp = 0;
   if(noofnodes != 0) {
     if (noofnodes > 1) {
       temp = front.getElement();
       Node temp1 = front.getLink();
       front.setLink(null);
       front = temp1;
     }
     if(noofnodes == 1) {
       temp = front.getElement();
       front = rear = null;
     }
     noofnodes--;
   } else {
     System.out.println("Queue is underflow");
   }
   return temp;
 }

 public boolean isEmpty() {
   if(noofnodes != 0){  
     return false;
   }else {
     return true;
   }
 } 
}