package lista1;
import java.util.Scanner;

//Fa�a um programa que recebe o n�mero de horas trabalhadas e o valor do sal�rio m�nimo, calcule e 
//mostre o sal�rio a receber seguindo estas regras:
//� a hora trabalhada vale a metade do sal�rio m�nimo;
//� o sal�rio bruto equivale ao n�mero de horas trabalhadas multiplicado pelo valor da hora trabalhada;
//� o imposto equivale a 3% do sal�rio bruto;
//� o sal�rio a receber equivale ao sal�rio bruto menos o imposto.

public class exercicio4 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o valor atual do sal�rio m�nimo. (usando a virgula para centavos): ");
        double salarioMinimo = tec.nextDouble(); 
        System.out.println("Informe o n�mero de horas trabalhadas");
        int horasTrabalhadas = tec.nextInt();
        double salarioBruto = horasTrabalhadas*(salarioMinimo/2);
        double salarioLiquido = salarioBruto - (salarioBruto*0.03); //ou salarioBruto*0.97;
        System.out.println("O seu sal�rio sera R$: "+salarioLiquido);        
	}
}
