package lista2;
import java.util.Scanner;

public class exercicio4 {
	public static void main(String[] args) {
		Scanner tec = new Scanner (System.in);
		int[] codigos = {1,2,3,4,5,6,7,8,9,10};
		double[] saldo = {750, 850.25, 950.50, 1050.75, 1151, 1251.25, 1351.50, 125.5, 185.40, 832.21};
		int opcao = 1;
		int codTransacao;
		double valorTransacao;
		
		while (opcao !=0) {
    		System.out.println();
			System.out.println("B A N C O   A M A R I L H O: ");
			System.out.println("Finalizar programa - 0 ");
			System.out.println("Efetuar depósito - 1 ");
			System.out.println("Efetuar saque - 2 ");
			System.out.println("Consultar o ativo bancário - 3 ");
			System.out.print("Informe o que você deseja: ");
	        opcao = tec.nextInt();
	        System.out.println();
	        
	        if(opcao != 0) {
	        	if(opcao == 1) {
	        		System.out.print("Informe o código da conta que você quer depositar: ");
	        		codTransacao = tec.nextInt();
	        		System.out.print("Informe o valor que você quer depositar: ");
	        		valorTransacao = tec.nextDouble();
	        		System.out.println();
	        		boolean aux = false;
	        		for(int i=0;i<codigos.length;i++) {
	        			if(codigos[i]==codTransacao) {
	        				saldo[i] += valorTransacao;
	        				aux = true;
	        			}
	        		}
	        		if(!aux) {
	        			System.out.println("Código incorreto: ");
	        		}	        	
	        	}
	        	if(opcao == 2) {
	        		System.out.print("Informe o código da conta que você quer fazer um saque: ");
	        		codTransacao = tec.nextInt();
	        		System.out.print("Informe o valor que você quer sacar: ");
	        		valorTransacao = tec.nextDouble();
	        		System.out.println();

	        		boolean aux = false;
	        		for(int i=0;i<codigos.length;i++) {
	        			if(codigos[i]==codTransacao) {
	        				saldo[i] -= valorTransacao;
	        				aux = true;
	        			}
	        		}
	        		if(!aux) {
	        			System.out.println("Código incorreto: ");
	        		}	 	        		
	        	}
	        	if(opcao == 3) {
	        		System.out.print("Informe o código da conta que você quer o extrato: ");
	        		codTransacao = tec.nextInt();
	        		System.out.println();
	        		boolean aux = false;
	        		for(int i=0;i<codigos.length;i++) {
	        			if(codigos[i]==codTransacao) {
	        				System.out.print("O saldo da conta "+codigos[i]+" é de: R$ "+saldo[i]);
	    	        		System.out.println();

	        				aux = true;
	        			}
	        		}
	        		if(!aux) {
	        			System.out.println("Código incorreto: ");
	        		}
	        	}	        	
	        }
	        if(opcao==0) {
	        	System.out.println("Obrigado por utilizar!");
	        }	
		}
	}
}
