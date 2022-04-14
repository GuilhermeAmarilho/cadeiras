package lista1;
import java.util.Scanner;

//Faça um programa que receba o salário base de um funcionário, calcule e mostre o
//salário a receber, sabendo-se que o funcionário tem gratificação de 5% sobre o salário
//base e paga imposto de 7% sobre este salário.
public class exercicio2 {

	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.print("Informe seu salário (usando a virgula para centavos): ");
        double salario = tec.nextDouble();
        double newSalario = salario + salario*0.05 - salario*0.07;
        
        System.out.println("Seu novo salário será R$: " + newSalario);
	}
}

