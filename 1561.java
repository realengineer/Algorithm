import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		long n = Long.parseLong(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int[] num = new int[m + 1];
		arr = in.readLine().split(" ");
		for (int i = 1; i <= m; i++)
			num[i] = Integer.parseInt(arr[i - 1]);

		long start = 1;
		long end = 200000000000L;
		long sum = 0;
		long mid = 0;
		if (n <= m) {
			System.out.print(n);
		} else {
			while (start < end) {
				mid = (start + end) / 2;
				sum = 0;
				for (int i = 1; i <= m; i++) {
					sum += (mid / num[i]);
				}
				sum += m;
				if (sum >= n)
					end = mid;
				if (sum < n)
					start = mid + 1;
			}
			int x = 0;
			start--;
			for (int i = 1; i <= m; i++)
				x += start / num[i];
			x += m;
			start++;
			for (int i = 1; i <= m; i++) {
				if ((start % num[i]) == 0)
					x++;
				if (x == n) {
					System.out.print(i);
					break;
				}
			}
		}
	}
}
