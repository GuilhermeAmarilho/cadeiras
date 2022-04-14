package lista1;
import java.util.Scanner;
//8. Faça um programa que leia um número e calcule o fatorial desse número

public class exercicio8 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o numero que você quer saber o fatorial: ");
        int valor = tec.nextInt();
		int fat = 1;	
		for( int i = 2; i <= valor; i++ ){
			fat *= i;
		}

		System.out.println( "O fatorial de " + valor + " é igual a " + fat );
	}
}
