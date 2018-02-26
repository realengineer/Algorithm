import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int A[] = new int[n];
		String[] str = in.readLine().split(" ");
		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(str[i]);
		int m = Integer.parseInt(in.readLine());
		Arrays.sort(A);
		String[] str2 = in.readLine().split(" ");
		for (int i = 0; i < m; i++)
			System.out.println(BinarySearch(A, 0, n - 1, Integer.parseInt(str2[i])));
	}

	public static int BinarySearch(int[] arr, int left, int right, int num) {
		int mid;
		while(left <= right){
			mid = (left+right)/2;
			if(arr[mid] == num)
				return 1;
			if(arr[mid] > num)
				right = mid-1;
			if(arr[mid] < num)
				left = mid+1;
		}
		
		return 0;
	}
}
