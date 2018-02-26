import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String a = sc.readLine();
		String[] aarr = a.split(" ");
		int treeCount = Integer.parseInt(aarr[0]);
		int height = Integer.parseInt(aarr[1]);
		int[] tree = new int[treeCount + 1];
		String b = sc.readLine();
		String[] barr = b.split(" ");

		for (int i = 0; i < treeCount; i++)
			tree[i] = Integer.parseInt(barr[i]);

		int right = tree[0];
		for (int i = 0; i < treeCount; i++) {
			if (right < tree[i])
				right = tree[i];
		}

		int left = 0;
		int max = left;
		while (left <= right) {
			long sum = 0;
			int middle = (left + right) / 2;
			for (int i = 0; i < treeCount; i++) {
				if (tree[i] > middle)
					sum += (tree[i] - middle);
			}

			if (sum > height) {
				max = middle;
				left = middle + 1;
			} else if (sum < height) {
				right = middle - 1;
			} else {
				max = middle;
				break;
			}
		}
		System.out.print(max);
	}
}