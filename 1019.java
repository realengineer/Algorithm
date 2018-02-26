import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String number = in.readLine();
		int n = Integer.parseInt(number);
		int prev = 0;
		int[] cnt = new int[10];
		for (int i = 1; 1 <= n; i *= 10) {
			int now = n % 10;
			n /= 10;
			for (int j = 0; j < now; j++)
				cnt[j] += (n + 1) * i;
			
			cnt[now] += n * i + prev + 1;
			
			for (int j = now + 1; j < 10; j++)
				cnt[j] += n * i;
			
			cnt[0] -= i;
			prev += now * i;
		}

		for (int i = 0; i < 10; i++)
			System.out.print(cnt[i] + " ");
	}
}