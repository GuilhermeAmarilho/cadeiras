package aula03;

import java.util.Scanner;

public class Notas {
	
	public static void main(String[] args) {
		double[] notas = new double[10];
		Scanner sc = new Scanner(System.in);
		double soma = 0, maior, menor;
		
		for (int i = 0; i < notas.length; i++) {
			System.out.print("Nota do aluno " + i + ": ");
			notas[i] = sc.nextDouble();			
			soma += notas[i];
		}
		
		maior = notas[0];
		menor = notas[0];
						
		for (double n : notas) {			
			if (n > maior)
				maior = n;
			
			if (n < menor)
				menor = n;
		}
				
		System.out.println("Média: " + (soma/notas.length));
		System.out.println("Maior: " + maior);
		System.out.println("Menor: " + menor);
		
	}

}
