package lista1;
import java.util.Scanner;
//Fa�a um programa que receba dez n�meros inteiros e mostre a quantidade de n�meros primos dentre os n�mero que foram digitados.


public class exercicio11 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        int[] numeros = new int[10];
        int cont = 0;
        double aux;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o "+(i+1)+" n�mero: ");
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
        System.out.println("Dos n�meros informados, "+cont+" s�o primos.");
	}
}
