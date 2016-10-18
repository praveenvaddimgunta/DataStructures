import java.util.*;
class MergeSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int [] array = new int[10];
		int size= 0;
		int low=0, high=9;
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input,",");
		while(st.hasMoreTokens()) {
			array[size++] = Integer.parseInt(st.nextToken());
		}
		Merge object = new Merge();
		object.mergesort(array,low,high);
		for (int m=0; m<array.length; m++) {
			if(array[m]!=0)
			System.out.print(array[m] + " ");
		}		
	}
}

class Merge {
	int[] sortarray;
	Merge() {
		sortarray = new int[10];
	}

	public void mergesort(int[] sortedarray,int low,int high) {
		if(low<high) {
			int middle = (low+high)/2;
			mergesort(sortedarray,low,middle);
			mergesort(sortedarray,middle+1,high);
			merge(sortedarray,low,middle,high);
		}
	}

	public void merge(int[] sortedarray, int low,int middle,int high) {
		int[] temp = new int[10];
		for(int i = low; i<=high;i++) {
			temp[i] = sortedarray[i];
		}
		int i = low;
		int j = middle+1;
		int k = low;
		while(i<=middle && j<=high) {
			if(temp[i] < temp[j]) {
				sortedarray[k] = temp[i];
				++i;
			}else {
				sortedarray[k] = temp[j];
				++j;
			}
			k++;
		}
		while(i<=middle) {
			sortedarray[k] = temp[i];
			++k;
			++i;
		}		
	}
}