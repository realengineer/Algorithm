import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
        int data[] = new int[n];
        
       for(int i = 0; i < n; i++){
    	   data[i] = Integer.parseInt(in.readLine());
       }
		QuickSort(data, 0, n - 1);
		for (int i = 0; i < n; i++)
			System.out.print(data[i] + " ");
	}

	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];

		while (left < right) {
			while (arr[left] < pivot && left < right)
				left++;
			while (arr[right] > pivot && left < right)
				right--;

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		return left;
	}

	public static void QuickSort(int[] arr, int left, int right) {
		if (left < right) {
			int newPivot = partition(arr, left, right);
			QuickSort(arr, left, newPivot - 1);
			QuickSort(arr, newPivot + 1, right);
		}

	}
}
