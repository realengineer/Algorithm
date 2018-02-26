import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());

		while (testCase-- > 0) {
			String[] arr = in.readLine().split(" ");
			int count = 0;
			String str1 = arr[0];
			String str2 = arr[1];
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();

			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == 'a')
					list1.add(i);
				if (str2.charAt(i) == 'a')
					list2.add(i);
			}

			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i) == list2.get(i))
					continue;
				else
					count += Math.abs(list1.get(i) - list2.get(i));
			}

			System.out.println(count);
		}
	}

}
