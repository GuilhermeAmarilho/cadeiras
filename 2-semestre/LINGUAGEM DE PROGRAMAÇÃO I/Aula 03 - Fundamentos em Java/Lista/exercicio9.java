package lista1;
import java.util.Scanner;
//9. Fa�a um programa que leia dois n�meros e apresente o fatorial de todos os n�meros 
//que estejam dentro do intervalo definido pelos n�meros que foram lidos


public class exercicio9 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o 1� numero: ");
        int valor1 = tec.nextInt();
        System.out.println("Informe o 2� numero: ");
        int valor2 = tec.nextInt();
        while (valor1<=valor2) {
        	int fat = 1;	
    		for( int i = 2; i <= valor1; i++ ){
    			fat *= i;
    		}
    		System.out.println( "O fatorial de " + valor1 + " � igual a " + fat );
        }
	}
}
