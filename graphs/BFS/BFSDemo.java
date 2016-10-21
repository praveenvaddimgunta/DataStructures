import java.util.*;
class BFSDemo{
    public static void main(String[] args)
    {

         BFS obj = new BFS();
        Scanner sc = new Scanner(System.in);
        int verticesNum = sc.nextInt();
        int select = sc.nextInt();
        int source;
        int adjmatrix[][];
        if (select == 1) {
        adjmatrix = new int[verticesNum+1][verticesNum+1];
        for (int i = 1; i <= verticesNum; i++)
            for (int j = 1; j <= verticesNum; j++)
                adjmatrix[i][j] = sc.nextInt();
                 source = 1;
       
                obj.bfs(adjmatrix,verticesNum);
       }
       else {
          adjmatrix = new int[verticesNum+1][verticesNum+1];
        Scanner sc1 = new Scanner(System.in);
        for (int i = 1 ; i <= verticesNum;i++) {
          String str = sc1.nextLine();
          StringTokenizer st = new StringTokenizer(str,"->");
          int m = Integer.parseInt(st.nextToken());
          while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            adjmatrix[m][n] = 1;
          }
        }
        obj.bfs(adjmatrix,verticesNum);
       }
        
    }
}

class BFS
{ 
    Queue<Integer> queue;
    public BFS()
    {
        queue = new LinkedList<Integer>();
    }
 
    public void bfs(int adjmatrix[][],int count)
    {
        int nodesNum = count;
        int src = 1;
        int visitStatus[];  //nodesNum
        int k=0;
        int value=0;
         visitStatus = new int[count+1];
        visitStatus[src] = 1;
        queue.add(src);
 
        while (!queue.isEmpty())
        {
            value = queue.remove();
            k = 1;
            System.out.print(value + " ");
            while (k <= nodesNum)
            {
                if (adjmatrix[value][k] == 1 && visitStatus[k] == 0)
                {
                    queue.add(k);
                    visitStatus[k] = 1;
                }
                k++;
            }
        }
    }
}