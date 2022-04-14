package lista1;
import java.util.Scanner;
//Faça um programa que receba dez números inteiros e mostre a quantidade de números primos dentre os número que foram digitados.


public class exercicio11 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        int[] numeros = new int[10];
        int cont = 0;
        double aux;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o "+(i+1)+" número: ");
            numeros[i] = tec.nextInt();      
            aux = 0;
            for (int j = 1; j <= numeros[i]; j++) {
            	if (numeros[i] % j == 0) {
            		aux += 0.5;
            	}
            }
            if(aux == 1 || numeros[i] == 1) {
            	cont++;
            }
        }
        System.out.println("Dos números informados, "+cont+" são primos.");
	}
}
