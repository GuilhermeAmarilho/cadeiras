package lista1;
import java.util.Scanner;

//Faça um programa que leia um número inteiro e diga se ele é primo

public class exercicio10 {
	public static void main(String args[]) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o numero que você quer saber se é primo: ");
        int numero = tec.nextInt();
        double aux = 0;
        for (int i = 1; i <= numero; i++) {
        	if (numero % i == 0) {
        		aux += 0.5;
        	}
        }
        if(aux == 1 || numero == 1) {
        	System.out.println("O número é primo");
        }else { 
        	System.out.println("O número não é primo");		
        }
        
    }
}
