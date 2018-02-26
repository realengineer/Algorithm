import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int l;
	static int c;
	static char[] alp;
	static char[] print;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		l = Integer.parseInt(arr[0]);
		c = Integer.parseInt(arr[1]);
		alp = new char[c + 1];
		print = new char[c + 1];
		String s = in.readLine();
		for (int i = 0; i < c; i++)
			alp[i] = s.charAt(2 * i);

		Arrays.sort(alp);

		for (int i = 0; i < c; i++)
			alp[i] = alp[i + 1];

		func(0, 0, 0, 0);
	}

	public static boolean isMo(char a) {
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
			return true;
		else
			return false;
	}

	public static void func(int cur, int len, int ja, int mo) {
		if (len == l) {
			if (ja >= 2 && mo >= 1) {
				for (int i = 0; i < l; i++)
					System.out.print(print[i]);
				System.out.println();
			}
		}
		for (int i = cur; i < c; i++) {
			print[len] = alp[i];
			func(i + 1, len + 1, ja + (!isMo(alp[i]) ? 1 : 0), mo + (isMo(alp[i]) ? 1 : 0));
		}
	}
}
