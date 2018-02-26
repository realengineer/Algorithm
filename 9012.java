import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());

		while (tc-- > 0) {
			String input = in.readLine();
			if(func(input))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static boolean func(String s) {
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (queue.isEmpty()) {
				if (s.charAt(i) == ')') {
					return false;
				}
			}
			if (s.charAt(i) == '(') {
				queue.add(1);
			} else if (s.charAt(i) == ')') {
				queue.poll();
			}
		}
		if (queue.isEmpty())
			return true;
		return false;
	}
}
