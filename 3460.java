package demicalToBinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());

		while (testCase-- > 0) {
			int value = Integer.parseInt(in.readLine());
			int count = 0;
			int result = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			while (true) {
				count = (value & 1);
				if (count == 1)
					q.add(result);
				result++;
				value = value >>> 1;
				if (value == 0)
					break;
			}

			while (!q.isEmpty())
				System.out.print(q.remove() + " ");
		}
	}
}
