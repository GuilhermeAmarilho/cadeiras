package aula03;

import java.util.Scanner;

public class LeitorTeclado {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);		
		
		System.out.print("Informe um número inteiro: ");
		int i = teclado.nextInt(); // lendo inteiro
		
		System.out.print("Informe um número real: ");
		double r = teclado.nextDouble(); // lendo real
		System.out.println("inteiro: " + i + ", real: " + r);
		
		teclado.nextLine();
		
		System.out.print("Entre com seu nome: ");
		String s = teclado.nextLine(); // lendo cadeia de caracteres
		System.out.println("Nome:" + s);
		
		teclado.close();
		
	}

}
