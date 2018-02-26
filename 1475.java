import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] num = new int[10];
		int sixNine;

		 		 
		    while (number != 0) {
		        num[number % 10]++;
		        number /= 10;
		    }
		    
		    sixNine = (num[9] + num[6] + 1) / 2;
		 
		    for (int i = 0; i < 9; i++) {
		        if (i != 9 && i != 6) {
		            if (num[i] > sixNine)    
		            	sixNine = num[i];
		        }
		    }
		    System.out.print(sixNine);
		}
}
