package aula23;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioExcecao {

	private Scanner ler = new Scanner(System.in);

	public int lerNumero(){
		System.out.print("Entre com um numero: ");
		int numero = 0;
				
		try {
			
			numero = ler.nextInt();
			
		}catch(InputMismatchException e) {
			
			LocalDateTime hora = LocalDateTime.now();
			int h = Integer.parseInt(hora.format(DateTimeFormatter.ofPattern("HH")));
			String saudacao = "";
			if (h>5 && h <= 12)
				saudacao = "bom dia";
			else
			if (h>12 && h <= 18)
				saudacao = "boa tarde";
			else
			if (h>18 && h <=23)
				saudacao = "boa noite";
			else
				saudacao = "vai dormir!";
				
			System.err.println("Querido usuário, " + saudacao + "...");
			System.err.println("Por favor, eu falei NÚMERO, e não LETRA!!!");
		}
		
		return numero;
	}
		
	
	public double divisao(int a, int b) throws ArithmeticException{
		double r = 0;
		
		if (b == 0) throw new ArithmeticException();
		
		r = (double)a / b;
		
		return r; 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}