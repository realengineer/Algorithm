import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine().toLowerCase();
		int array[] = new int[26];
		for (int i = 0; i < input.length(); i++) {
			char al = input.charAt(i);
			int order = al - 'a';
			array[order]++;
		}

		int max = array[0];
		int num = 0;
		for (int i = 0; i < 26; i++) {
			if (array[i] > max) {
				max = array[i];
				num = i;
			}
		}

		Arrays.sort(array);
		if (array[25] == array[24])
			System.out.print("?");
		else {
			char out = (char) (num + 'a');
			String output = Character.toString(out).toUpperCase();
			System.out.print(output);
		}
	}
}
