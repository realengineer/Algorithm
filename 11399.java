import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size + 1];
		
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr);

		int result = 0;
		for(int i = 1; i < size+1; i ++){
			result += arr[i] * (size - i + 1);
		}		
		
		System.out.print(result);
	}
}
