import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		cnt += n / 5;
		cnt += n / 25;
		cnt += n / 125;

		System.out.print(cnt);
	}
}
