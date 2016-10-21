import java.util.*;
class Queue {
	private int size = 200;
	private int [] quearray;
	private int front;
	private int rear;
	public Queue() {
		quearray = new int[size];
		front = 0;
		rear = -1;
	}
	public void insert(int j) {
		if(rear==size-1)
			rear = -1;
		quearray[++rear] = j;
	}
	public int remove() {
		 int temp = quearray[front++];
		 if(front==size)
		 	front = 0;
		 return temp;
	}
	public boolean isEmpty() {
		return(rear+1==front||(front+size==rear));
	}
}
class BFS {
	Queue theQueue;
	public BFS(){
		theQueue = new Queue();
	}
	public void bfs(int[][] adjMatrix,int count) {
		int num_nodes;
		num_nodes = count;
		int s1;
		s1 = 1;
		int []wasVisited;
		int k = 0;
		int value = 0;
		wasVisited = new int[count+1];
		wasVisited[s1] = 1;
		theQueue.insert(s1);
		while(!theQueue.isEmpty()) {
			value = theQueue.remove();
			k=1;
			System.out.print(value+" ");
			while(k<=num_nodes) {
				if(adjMatrix[value][k]==1 && wasVisited[k]==0) {
					theQueue.insert(k);
					wasVisited[k] = 1;
				}
				k++;
			}
		}
	}
}
class BFSAssign {
	public static void main(String args[]) {
		BFS object = new BFS();
		Scanner sc = new Scanner(System.in);
		int vertices_count = sc.nextInt();
		int choice = sc.nextInt();
		int s,m,l;
		int[][] adjMatrix;
		if(choice==0){
			adjMatrix =new int[vertices_count+1][vertices_count+1];
			Scanner c = new Scanner(System.in);
			for(int i=1;i<=vertices_count;i++) {
				String str1 = c.nextLine();
				StringTokenizer st = new StringTokenizer(str1,"->");
				l = Integer.parseInt(st.nextToken());
				while(st.hasMoreTokens()) {
					 m = Integer.parseInt(st.nextToken());
					adjMatrix[l][m] = 1; 
				}
			}
			object.bfs(adjMatrix,vertices_count);
		}
		else if(choice==1) {
			adjMatrix = new int[vertices_count+1][vertices_count+1];
			for(int i= 1; i<=vertices_count;i++)
				for(int j=1; j<=vertices_count;j++)
					adjMatrix[i][j] = sc.nextInt();
				s=1;
				object.bfs(adjMatrix,vertices_count);
		}
		else {
		    System.out.println("Invalid Input");
		}
	}
}

