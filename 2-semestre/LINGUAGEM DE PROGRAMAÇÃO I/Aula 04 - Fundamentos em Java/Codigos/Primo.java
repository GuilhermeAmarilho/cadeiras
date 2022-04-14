package aula04;

import java.util.Scanner;

public class Primo {
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Forneça um número inteiro");
		int n = ler.nextInt();
		boolean primo = true;
		
		for (int i = 2; i <= (n/2); i++) {
			if (n % i == 0) {
				primo = false;
				break;
			}			
		}		
		if (primo)
			System.out.println("Primo");
		else
			System.out.println("Não é primo");
	}

}
