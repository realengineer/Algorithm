import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String first = in.readLine();
		String second = in.readLine();
		int array[] = new int[26];

		for(int i = 0; i < first.length(); i++)
			array[first.charAt(i) - 'a']++;
		
		for(int i = 0; i < second.length(); i++)
			array[second.charAt(i) - 'a']--;
		int res = 0;
		for(int i = 0; i < 26; i++)
			res += Math.abs(array[i]);
		
		System.out.print(res);
	}
}
