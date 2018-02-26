import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String a = sc.readLine();
		String b = sc.readLine();
		int n = Integer.parseInt(a);
		int k = Integer.parseInt(b);

		int l, r, m;
		l = 1;
		r = k;

		while (l <= r) {
			BigInteger c = BigInteger.valueOf(0);
			m = (l + r) / 2;
			for (int i = 1; i <= n; i++)
				c = c.add(BigInteger.valueOf(Math.min(n, m / i))); //c += Math.min(n, m/i);
			if (c.compareTo(BigInteger.valueOf(k)) == -1) // c < k
				l = m + 1;
			else
				r = m - 1;
		}
		System.out.print(l);
	}
}
