package lista2;
import java.util.Random;

public class exercicio5 {
	public static void main(String[] args) {
		Random gerador = new Random();	
		int[][] matriz = new int[7][7];
		int[] maiorDaLinha = new int[7];		
		int[] menorDaColuna = new int[7];
		int aux;
		
		for	(int i=0;i<7;i++) {		//gerei a matriz
			for (int j=0;j<7;j++) {
				matriz[i][j] = gerador.nextInt(11);
			}
		}
		for	(int i=0;i<7;i++) { //calculo o maior de cada linha e coloco no maiorDaLinha
			aux = matriz[i][0];	//fiz separado para melhorar o entendimento
			for (int j=0;j<7;j++) {
				if(matriz[i][j] > aux) {
					aux = matriz[i][j];
				}
			}
			maiorDaLinha[i] = aux;
		}
		for	(int i=0;i<7;i++) { //calculo o menor de cada coluna e coloco no menorDaColuna
			aux = matriz[0][i];	
			for (int j=0;j<7;j++) {
				if(matriz[j][i] < aux) {
					aux = matriz[j][i];
				}
			}
			menorDaColuna[i] = aux;
		}
		System.out.println("Matriz");
		for	(int i=0;i<7;i++) {		//matriz
			System.out.println("["+matriz[i][0]+"]"+"["+matriz[i][1]+"]"+"["+matriz[i][2]+"]"+"["+matriz[i][3]+"]"+"["+matriz[i][4]+"]"+"["+matriz[i][5]+"]"+"["+matriz[i][6]+"]");
		}
		System.out.println();
		System.out.println("Maiores de cada linha");
		System.out.println("["+maiorDaLinha[0]+"]"+"["+maiorDaLinha[1]+"]"+"["+maiorDaLinha[2]+"]"+"["+maiorDaLinha[3]+"]"+"["+maiorDaLinha[4]+"]"+"["+maiorDaLinha[5]+"]"+"["+maiorDaLinha[6]+"]");
		System.out.println();
		System.out.println("Menores de cada coluna");
		System.out.println("["+menorDaColuna[0]+"]"+"["+menorDaColuna[1]+"]"+"["+menorDaColuna[2]+"]"+"["+menorDaColuna[3]+"]"+"["+menorDaColuna[4]+"]"+"["+menorDaColuna[5]+"]"+"["+menorDaColuna[6]+"]");

	}
}
