import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n + 1];
		String[] str = in.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(str[i]);

		Arrays.sort(arr);

		int result = 0;
		for (int i = 1; i < n; i++)
			result += arr[i];

		System.out.print(result);
	}
}
