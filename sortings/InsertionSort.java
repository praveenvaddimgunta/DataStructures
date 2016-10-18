import java.util.*;
class InsertionSort {
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
		Insertion object = new Insertion();
		object.insertionsort(array);
	}
}

class Insertion {
	int[] sortarray;
	Insertion() {
		sortarray = new int[10];
	}
	public void insertionsort(int[] arr) {
		int n = arr.length;
		int i, j, temp;
		for (i = 1; i< n; i++) {
			j = i;
			temp = arr[i];
			while (j > 0 && temp < arr[j-1]) {
				arr[j] = arr[j-1];
				j = j-1;
			}
			arr[j] = temp;
		}
		for(i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}