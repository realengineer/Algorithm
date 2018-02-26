import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        char a = input.charAt(0);
        int al = a;
        System.out.println(al);
    }
}