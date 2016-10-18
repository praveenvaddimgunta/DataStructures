import java.util.*;
class QuickSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		int size =0;
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input,",");
		while(st.hasMoreTokens()) {
		 	array[size++] =Integer.parseInt(st.nextToken()); 
		}
		Quick object = new Quick();
		object.quicksort(array);
		for(int i = 0; i<array.length; i++) {
			if(array[i]!=0) {
				System.out.print(array[i]+" ");
			}
		}
	}
}

class Quick {
	private int[] array;
	private int length;
	Quick() {
		array = new int[10];
	}
	public void quicksort(int[] inputarray) {
		this.array = inputarray;
		length = inputarray.length;
		quicksort(0,length-1);
	}
	public void quicksort(int low, int high) {
		int i = low;
		int j = high;
		int pivot = array[low+(high-low)/2];
		while(i<=j) {
			while(array[i]<pivot) {
				i++;
			}
			while(array[j]>pivot) {
				j--;
			}
			if(i<=j) {
				swap(i,j);
				i++;
				j--;
			}
		}
		if(low<j) {
			quicksort(low,j);
		}
		if(i<high)
			quicksort(i,high);
	}
	public void swap(int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}