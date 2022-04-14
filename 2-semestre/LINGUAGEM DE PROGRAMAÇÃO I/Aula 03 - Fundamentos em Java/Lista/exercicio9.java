package lista1;
import java.util.Scanner;
//9. Faça um programa que leia dois números e apresente o fatorial de todos os números 
//que estejam dentro do intervalo definido pelos números que foram lidos


public class exercicio9 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o 1º numero: ");
        int valor1 = tec.nextInt();
        System.out.println("Informe o 2º numero: ");
        int valor2 = tec.nextInt();
        while (valor1<=valor2) {
        	int fat = 1;	
    		for( int i = 2; i <= valor1; i++ ){
    			fat *= i;
    		}
    		System.out.println( "O fatorial de " + valor1 + " é igual a " + fat );
        }
	}
}
