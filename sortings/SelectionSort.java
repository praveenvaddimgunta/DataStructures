import java.util.*;
class SelectionSort {
	public static void main(String[] args) {
		int size=0;
		int[] array = new int[10];
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str,", ");
		while(st.hasMoreTokens()) {
			array[size++] = Integer.parseInt(st.nextToken());
			//System.out.println(array);
		}
		Selection object = new Selection();
		object.selectionsort(array);
	}
}
class Selection {
	int[] sortarray;
	Selection() {
		sortarray = new int[10];
	}
	public void selectionsort(int[] arr) {
		int n = arr.length;
		int i, j, pos, temp;
		for (i = 0; i < n-1; i++) {
			pos = i;
			for (j = i+1; j < n; j++) {
				if (arr[j] < arr[pos]) {
					pos = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[pos];
			arr[pos]= temp;
		}
		for(i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}