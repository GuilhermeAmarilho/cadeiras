package lista1;
import java.util.Scanner;

//Faça um programa que recebe o número de horas trabalhadas e o valor do salário mínimo, calcule e 
//mostre o salário a receber seguindo estas regras:
//• a hora trabalhada vale a metade do salário mínimo;
//• o salário bruto equivale ao número de horas trabalhadas multiplicado pelo valor da hora trabalhada;
//• o imposto equivale a 3% do salário bruto;
//• o salário a receber equivale ao salário bruto menos o imposto.

public class exercicio4 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o valor atual do salário mínimo. (usando a virgula para centavos): ");
        double salarioMinimo = tec.nextDouble(); 
        System.out.println("Informe o número de horas trabalhadas");
        int horasTrabalhadas = tec.nextInt();
        double salarioBruto = horasTrabalhadas*(salarioMinimo/2);
        double salarioLiquido = salarioBruto - (salarioBruto*0.03); //ou salarioBruto*0.97;
        System.out.println("O seu salário sera R$: "+salarioLiquido);        
	}
}
