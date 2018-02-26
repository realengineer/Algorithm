import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n + 1];
		String[] str = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(str[i - 1]);

		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 1; i<=n; i++){
			stack.push(arr[i]);
			if(stack.size() == 6){
				for(int a : stack)
					System.out.print(a + " ");
			}
			stack.pop();
		}
	}
}
