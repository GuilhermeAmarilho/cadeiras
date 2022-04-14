package aula04;

import java.util.Scanner;

public class Triangulos {
	
	public static void verificaAngulosTriangulo(int angA, int angB, int angC) {
		if ((angA > 0) && (angB > 0) && (angC > 0) && 
				(angA + angB + angC == 180)) {		
			if (angA == 90 || angB == 90 || angC == 90) {
				System.out.println("Triângulo retângulo");
			}else
			if (angA > 90 || angB > 90 || angC > 90) {
				System.out.println("Triângulo obtusângulo");
			}else {
				System.out.println("Triângulo acutângulo");
			}
		}else {
			System.out.println("Querido usuário, isso não é um triângulo!");
		}
	}
	
	public static void verificaLadosTriangulo(int ladoA, int ladoB, int ladoC) {
		if ((ladoA > 0) && (ladoB > 0) && (ladoC > 0) &&
				(ladoA + ladoB > ladoC) && 
				(ladoA + ladoC > ladoB) &&
				(ladoB + ladoC > ladoA)){
				
				if (ladoA == ladoB && ladoA == ladoC) {
					System.out.println("Equilátero");
				}else
				if (ladoA != ladoB && ladoA != ladoC && ladoB != ladoC) {
					System.out.println("Escaleno");
				}else {
					System.out.println("Isóceles");
				}
							
			}else {
				System.out.println("Querido usuário, isso não é um triângulo!");
			}
	}
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		int angA, angB, angC;
		int ladoA, ladoB, ladoC; 
		
		System.out.println("Forneça os 03 ângulos do triângulo:");
		angA = ler.nextInt();
		angB = ler.nextInt();
		angC = ler.nextInt();

		verificaAngulosTriangulo(angA, angB,angC);
						
		System.out.println("Forneça os 03 lados do triângulo:");
		ladoA = ler.nextInt();
		ladoB = ler.nextInt();
		ladoC = ler.nextInt();
		
		verificaLadosTriangulo(ladoA, ladoB, ladoC);
	}

}













