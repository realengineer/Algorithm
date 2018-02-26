import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String bracket = in.readLine();
		int countOpen = 0;
		int result = 0;
		for(int i = 0; i < bracket.length()-1; i++){
			if(bracket.charAt(i) == '(' && bracket.charAt(i+1) == ')')
				result += countOpen; 
			if(bracket.charAt(i) == '(' && bracket.charAt(i+1) == '(')
				countOpen++;
			if(bracket.charAt(i) == ')' && bracket.charAt(i+1) == ')'){
				countOpen--;
				result++;
			}
		}
		
		System.out.print(result);
	}
}
