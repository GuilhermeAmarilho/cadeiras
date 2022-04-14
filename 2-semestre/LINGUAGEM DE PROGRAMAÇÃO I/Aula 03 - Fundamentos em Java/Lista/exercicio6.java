package lista1;
import java.util.Scanner;

//6. Faça uma calculadora de troco, baseado nas cédulas da nossa moeda.

public class exercicio6 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        System.out.println("Informe o valor da sua compra: ");
        double valorCompra = tec.nextDouble();
        System.out.println("Informe quanto você deu ao caixa: ");
        double valorTroco = tec.nextDouble();
        String listaTroco = "Você receberá ";
        double troco = valorTroco - valorCompra;
        int auxiliar = 0;
        if (troco > 0){
        	if(troco / 50 >= 1) {
        		auxiliar = (int) (troco/50);
        		listaTroco += auxiliar + " notas de R$ 50.00; ";
        		troco-= auxiliar*50;        		        		
        	}
        	if(troco / 20 >= 1){
        		auxiliar = (int) (troco/20);
        		listaTroco += auxiliar + " notas de R$ 20.00; ";
        		troco-= auxiliar*20; 
        	}
        	if(troco / 10 >= 1){
        		auxiliar = (int) (troco/10);
        		listaTroco += auxiliar + " notas de R$ 10.00; ";
        		troco-= auxiliar*10; 
        	}
        	if(troco / 5 >= 1){
        		auxiliar = (int) (troco/5);
        		listaTroco += auxiliar + " notas de R$ 5.00; ";
        		troco-= auxiliar*5; 
        	}
        	if(troco / 2 >= 1){
        		auxiliar = (int) (troco/2);
        		listaTroco += auxiliar + " notas de R$ 2.00; ";
        		troco-= auxiliar*2; 
        	}
        	if(troco / 1 >= 1){
        		auxiliar = (int) (troco/1);
        		listaTroco += auxiliar + " moeda(s) de R$ 1.00; ";
        		troco-= auxiliar*1; 
        	}
        	if(troco / 0.5 >= 1){
        		auxiliar = (int) (troco/0.5);
        		listaTroco += auxiliar + " moeda(s) de R$ 0.50; ";
        		troco-= auxiliar*0.5; 
        	}
        	if(troco / 0.25 >= 1){
        		auxiliar = (int) (troco/0.25);
        		listaTroco += auxiliar + " moeda(s) de R$ 0.25; ";
        		troco-= auxiliar*0.25; 
        	}
        	if(troco / 0.10 >= 1){
        		auxiliar = (int) (troco/0.10);
        		listaTroco += auxiliar + " moeda(s) de R$ 0.10; ";
        		troco-= auxiliar*0.10; 
        	}
        	if(troco / 0.05 >= 1){
        		auxiliar = (int) (troco/0.05);
        		listaTroco += auxiliar + " moeda(s) de R$ 0.05; ";
        		troco-= auxiliar*0.05; 
        	}
        	if(troco / 0.01 >= 1){
        		auxiliar = (int) (troco/0.01);
        		listaTroco += auxiliar + " moeda(s) de R$ 0.01; ";
        		troco-= auxiliar*0.01; 
        	}
        	System.out.println(listaTroco);
        }else {
        	System.out.println("Faltou dinheiro para pagar suas compras!");
        }
        
	}
}
