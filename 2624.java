import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());

		int[][] D = new int[K + 1][T + 1];
		int[] Pi = new int[K + 1];
		int[] Ni = new int[K + 1];

		for (int i = 1; i <= K; i++) {
			String[] str = in.readLine().split(" ");
			D[i][0] = 1; // j위치에서 현재동전금액을 뺀곳의 값을 참조함

			Pi[i] = Integer.parseInt(str[0]);
			Ni[i] = Integer.parseInt(str[1]);
		}

		D[0][0] = 1;

		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= T; j++) {
				// 이전 동전이 만든 잔돈과
				// 내가 만들 잔돈을 더해 주면
				// 잔돈을 만들수 있는 케이스가 합쳐진다.
				for (int k = 0; k <= Ni[i]; k++) {
					if (Pi[i] * k > j)
						break;
					D[i][j] += D[i - 1][j - Pi[i] * k];
				}
			}
		}

		System.out.println(D[K][T]);

	}
}