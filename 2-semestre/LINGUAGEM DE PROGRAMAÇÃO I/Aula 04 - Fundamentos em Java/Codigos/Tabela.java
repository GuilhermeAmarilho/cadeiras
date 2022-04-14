package aula04;

import java.util.Scanner;

public class Tabela {
	
	public static void main(String[] args) {
		
		float[] numeros = new float[100];
		Scanner ler = new Scanner(System.in);
		//tamanho final do vetor lido
		int i = 0;
		float aux;
		
		System.out.println("Forneça números inteiros positivos (zero ou negativo para sair):");
		while (true) {
			aux = ler.nextFloat();
			if (aux > 0) {
				numeros[i] = aux;				
			}else
				break;
			i++;
		}
		
		for (int j = 0; j < i; j++) {						
			if (j % 5 == 0)
				System.out.printf("%10s %10s %10s \n","Número", "Cubo", "Raiz");
			
			System.out.printf("%10.2f %10.2f %10.2f \n", numeros[j], Math.pow(numeros[j], 3), Math.sqrt(numeros[j]));			
		}
	}

}
