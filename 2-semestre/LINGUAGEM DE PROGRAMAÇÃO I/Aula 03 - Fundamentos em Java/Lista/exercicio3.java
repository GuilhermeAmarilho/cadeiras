package lista1;
import java.util.Scanner;

//Sabe-se que o quilowatt de energia custa um quinto do sal�rio m�nimo. Fa�a um programa que recebe 
//o valor do sal�rio m�nimo e a quantidade de quilowatts consumidapor uma resid�ncia, calcule e mostre:
// O valor do kW, o valor a ser pago por essa residencia, o valor a ser pago com 15% de desconto.

public class exercicio3 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o valor atual do sal�rio m�nimo. (usando a virgula para centavos): ");
        double salarioMinimo = tec.nextDouble(); 
        System.out.println("Informe quantos kW de energia foram consumidos em sua resid�ncia (usando a virgula para valores decimais): ");
        double kWGasto = tec.nextDouble(); 
        double valorKW = salarioMinimo/5;
        System.out.println("O valor do kW � de R$: "+valorKW);
        double valorResidencia = valorKW * kWGasto;
        System.out.println("O seu consumo mensal de energia � de R$: "+valorResidencia);
        double valorResidencia15 = valorResidencia*0.85;
        System.out.println("O seu consumo mensal de energia com 15% de desconto � de R$: "+valorResidencia15);     
	}
}
