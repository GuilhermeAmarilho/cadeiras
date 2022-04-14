package lista1;
import java.util.Scanner;

public class exercicio1 {
	public static void main(String[] args) {		
		Scanner tec = new Scanner (System.in);
		
        System.out.println("Informe o priemeiro lado: ");
        int x = tec.nextInt();
        System.out.println("Informe o segundo lado: ");
        int y = tec.nextInt();
        System.out.println("Informe o terceiro lado: ");
        int z = tec.nextInt();
				
		if (x < y + z || y < x + z || z < x+y){
			System.out.println("Trata-se de um triangulo");
		}
		if (x == y && x == z){
			System.out.println("Três lados iguais . Trata-se de um Triangulo Equilatero");
		}else if(x == y || x == z){
			System.out.println("Dois lados iguais . Trata-se de um Triangulo Isosceles");
		}else {
			System.out.println("Três lados diferentes.");
		}
	}
}
