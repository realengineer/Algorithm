import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int[] arr = new int[5000];

	public static void main(String[] args) throws IOException {
		int l = 0, r = 9999, c;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		input = in.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);
		while (l <= r) {
			c = (l + r) / 2;
			if (dp(c) > m)
				l = c + 1;
			else
				r = c - 1;
		}
		System.out.print(l);
	}

	public static int dp(int x) {
		int min = arr[0];
		int max = arr[0];
		int result = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] < min)
				min = arr[i];
			if (arr[i] > max)
				max = arr[i];
			if (max - min > x) {
				min = max = arr[i];
				result++;
			}
		}
		return result;
	}
}
