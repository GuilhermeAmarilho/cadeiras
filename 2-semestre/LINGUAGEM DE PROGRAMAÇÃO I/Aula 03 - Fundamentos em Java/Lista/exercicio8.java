package lista1;
import java.util.Scanner;
//8. Fa�a um programa que leia um n�mero e calcule o fatorial desse n�mero

public class exercicio8 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o numero que voc� quer saber o fatorial: ");
        int valor = tec.nextInt();
		int fat = 1;	
		for( int i = 2; i <= valor; i++ ){
			fat *= i;
		}

		System.out.println( "O fatorial de " + valor + " � igual a " + fat );
	}
}
