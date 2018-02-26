import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String a = in.readLine();
			if (a.equals("0 0.00"))
				break;
			String aarr[] = a.split(" ");
			int candyCount = Integer.parseInt(aarr[0]);
			int myMoney = (int) (Double.parseDouble(aarr[1]) * 100);
			int[] candyCal = new int[candyCount + 1];
			int[] candyCost = new int[candyCount + 1];

			for (int i = 0; i < candyCount; i++) {
				String b = in.readLine();
				String[] barr = b.split(" ");
				candyCal[i] = Integer.parseInt(barr[0]);
				candyCost[i] = (int) (Double.parseDouble(barr[1]) * 100);
			}

			int[] dp = new int[myMoney + 1];
			for (int i = 0; i <= myMoney; i++) {
				for (int j = 0; j < candyCount; j++) {
					if (i >= candyCost[j])
						dp[i] = Math.max(dp[i], dp[i - candyCost[j]] + candyCal[j]);
				}
			}
			System.out.println(dp[myMoney]);
		}
		in.close();
	}
}