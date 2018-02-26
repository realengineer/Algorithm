import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int vipSize = sc.nextInt();

		int[] vip = new int[41];
		int[] dif = new int[42];

		for (int i = 0; i < vipSize; i++) {
			vip[i] = sc.nextInt();
		}

		for (int i = 0; i < vipSize - 1; i++) {
			dif[i + 1] = vip[i + 1] - vip[i] - 1;
		}

		dif[0] = vip[0] - 1;
		if (vipSize != 0)
			dif[vipSize] = size - vip[vipSize - 1];

		int result = 1;

		if (vipSize != 0) {
			for (int i = 0; i < vipSize + 1; i++) {
				result *= fib(dif[i]);
			}
		} else{
				result = fib(size);
		}
		System.out.print(result);
	}

	public static int fib(int number) {
		if (number <= 1) {
			return 1;
		}

		return fib(number - 1) + fib(number - 2);
	}
}
