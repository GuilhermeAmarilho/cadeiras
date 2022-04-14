package aula03;

import java.util.Scanner;

public class CalculadoraSimples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x,y,r;
		char op;
		
		System.out.println("Digite a operação matemática que deseja realizar (+ - * /) : ");
		op = sc.next().charAt(0);
		
		System.out.println("Forneça dois números inteiros");
		System.out.print("X: ");
		x = sc.nextInt();
		System.out.print("Y: ");
		y = sc.nextInt();
		
		switch (op) {
			case '+':
				r = x+y;
				System.out.println("O resultado da soma é " + r);
				break;
			case '-':
				r = x-y;
				System.out.println("O resultado da subtração é " + r);
				break;
			case '*':
				r = x*y;
				System.out.println("O resultado da multiplicação é " + r);
				break;
			case '/':
				r = x/y;
				System.out.println("O resultado da divisão é " + r);
				break;
			default:
				System.out.println("Esta operação matemática não existe, ou a calculadora não suporta.");
				break;
		}					
		sc.close();
	}
}
