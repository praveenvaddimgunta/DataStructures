/**
 * Java Program to Implement K Way Merge Algorithm
 **/
 
import java.util.Scanner;
 
/** Class KWayMerge **/
public class KWayMerge
{
    /** Function to merge arrays **/
    private int[] merge(int[][] arr) 
    {
        int K = arr.length;
        int N = arr[0].length;
 
        /** array to keep track of non considered positions in subarrays **/
        int[] curPos = new int[K];
 
        /** final merged array **/
        int[] mergedArray = new int[K * N];
        int p = 0;
 
        while (p < K * N)
        {
            int min = Integer.MAX_VALUE;
            int minPos = -1;
            /** search for least element **/
            for (int i = 0; i < K; i++)
            {
                if (curPos[i] < N)
                {
                    if (arr[i][curPos[i]] < min)
                    {
                        min = arr[i][curPos[i]];
                        minPos = i;
                    }
                }                
            }
            curPos[minPos]++;            
            mergedArray[p++] = min;
        }
        return mergedArray;
    }
 
    /** Main method **/
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("K Way Merge Test\n");
 
        /** Accept k and n **/
        System.out.println("Enter K and N");
        int K = scan.nextInt();
        int N = scan.nextInt();
 
        int[][] arr = new int[K][N];
        /** Accept all elements **/
        System.out.println("Enter "+ K +" sorted arrays of length "+ N);
 
        for (int i = 0; i < K; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = scan.nextInt();
 
        KWayMerge kwm = new KWayMerge();
 
        int[] mergedArray = kwm.merge(arr);
        /** Print merged array **/
        System.out.println("\nMerged Array : ");
        for (int i = 0; i < mergedArray.length; i++)
            System.out.print(mergedArray[i] +" ");
        System.out.println(); 
 
    }    
}