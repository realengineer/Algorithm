import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		int[] num = new int[n + 1];
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(arr[i]);

		arr = in.readLine().split(" ");
		int b = Integer.parseInt(arr[0]);
		int c = Integer.parseInt(arr[1]);
		long count = 0;

		for (int i = 0; i < n; i++) {
			num[i] = num[i] - b;
			count++;
			if (num[i] > 0) {
				int q = num[i] / c;
				int r = num[i] % c;
				count += q;
				if (r != 0)
					count ++;
			}
		}

		System.out.print(count);
	}
}