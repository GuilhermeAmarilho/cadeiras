package aula03;

import java.util.Scanner;

public class DiaMes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um mês (01 a 12):");
		
		int mes = sc.nextInt();
		
		switch (mes) {
			case 1: 
			case 3: 
			case 5: 
			case 7: 
			case 8: 
			case 10:
			case 12:
				System.out.println("31 dias");
				break;
			case 2:
				System.out.println("28 dias");
				break;
			case 4: 
			case 6: 
			case 9: 
			case 11:
				System.out.println("30 dias");
				break;
									
			default:
				System.out.println("Querido usuário, os meses do ano são de 01 a 12!");
		}		
			
		sc.close();

	}

}
