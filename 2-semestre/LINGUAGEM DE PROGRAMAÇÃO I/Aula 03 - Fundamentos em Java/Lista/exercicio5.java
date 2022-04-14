package lista1;
import java.util.Scanner;

//Faça um programa que receba: O código do produto comprado;A quantidade comprada do produto
//Calcule e mostre:
//• O preço unitário do produto comprado, seguindo a Tabela I;
//• O preço total da nota;
//• O valor do desconto, seguindo a Tabela II e aplicado sobre o preço total da nota;
//• O preço final da nota depois do desconto.

public class exercicio5 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o código do produto: ");
        int codigo = tec.nextInt();
        System.out.println("Informe a quantidade comprada: ");
        int quantidade = tec.nextInt();
        int precoProduto = 0;
        if(codigo > 0 && codigo <= 10) {
        	precoProduto = 10;
        }else if(codigo > 10 && codigo <= 20) {
        	precoProduto = 15;
        }else if(codigo > 20 && codigo <= 30) {
        	precoProduto = 20;
        }else if(codigo > 30 && codigo <= 40) {
        	precoProduto = 40;
        }else {
        	precoProduto = -1;
        	System.out.println("Você informou um código inválido!");
        }
        if(precoProduto != -1) {
	        System.out.println("O preço unitário do produto é de: R$ "+precoProduto);
	        
	        int precoTotal = precoProduto*quantidade;
	        System.out.println("O total da nota é de: R$ "+precoTotal);
	        
	        double desconto = 0;
	        if (precoTotal<250) {
	        	desconto = precoTotal*0.05;
	        }else if(precoTotal<=500){
	        	desconto = precoTotal*0.10;
	        }else if(precoTotal>500){
	        	desconto = precoTotal*0.15;
	        }
	        System.out.println("Na sua nota há um desconto de: R$ "+desconto);
	        
	        double precoFinal = precoTotal - desconto;
	        System.out.println("O valor final da sua nota é de: R$ "+precoFinal);

	        
        }
        
        
	}
}
