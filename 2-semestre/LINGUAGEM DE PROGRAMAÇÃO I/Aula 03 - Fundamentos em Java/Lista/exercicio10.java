package lista1;
import java.util.Scanner;

//Fa�a um programa que leia um n�mero inteiro e diga se ele � primo

public class exercicio10 {
	public static void main(String args[]) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o numero que voc� quer saber se � primo: ");
        int numero = tec.nextInt();
        double aux = 0;
        for (int i = 1; i <= numero; i++) {
        	if (numero % i == 0) {
        		aux += 0.5;
        	}
        }
        if(aux == 1 || numero == 1) {
        	System.out.println("O n�mero � primo");
        }else { 
        	System.out.println("O n�mero n�o � primo");		
        }
        
    }
}
