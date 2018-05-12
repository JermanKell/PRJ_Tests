package Test_boucle;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String coucou = null;
		
		boolean tries = true;
		while (tries) {
			
				coucou = sc.nextLine();
				tries = false;
			
		}
		System.out.println(coucou);
		sc.close();
	}
}
