import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		
		if(a + b < 2 * c)
			System.out.print(a + b);
		else
			System.out.print((a+b) - (2 * c));
	}

}
