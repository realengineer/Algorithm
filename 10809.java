import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine().toLowerCase();
		int array[] = new int[26];
		for (int i = 0; i < 26; i++) {
			array[i] = -1;
		}
		for (int i = 0; i < input.length(); i++) {
			char al = input.charAt(i);
			int order = al - 'a';
			if (array[order] == -1)
				array[order] = i;
		}

		for (int i = 0; i < 26; i++)
			System.out.print(array[i] + " ");
	}
}
