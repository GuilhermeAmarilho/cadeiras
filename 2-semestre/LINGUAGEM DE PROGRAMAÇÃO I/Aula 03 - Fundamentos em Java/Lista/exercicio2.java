package lista1;
import java.util.Scanner;

//Fa�a um programa que receba o sal�rio base de um funcion�rio, calcule e mostre o
//sal�rio a receber, sabendo-se que o funcion�rio tem gratifica��o de 5% sobre o sal�rio
//base e paga imposto de 7% sobre este sal�rio.
public class exercicio2 {

	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.print("Informe seu sal�rio (usando a virgula para centavos): ");
        double salario = tec.nextDouble();
        double newSalario = salario + salario*0.05 - salario*0.07;
        
        System.out.println("Seu novo sal�rio ser� R$: " + newSalario);
	}
}

