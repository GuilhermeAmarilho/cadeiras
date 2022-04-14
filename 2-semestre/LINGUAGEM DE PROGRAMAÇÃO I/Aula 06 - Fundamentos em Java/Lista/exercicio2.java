package lista2;
import java.util.Scanner;

public class exercicio2 {
	public static void main(String[] args) {	
		Scanner tec = new Scanner (System.in);

		int[] vetor1 = new int[10];
		int[] vetor2 = new int[10];
		int[] aux = new int[(vetor1.length+vetor2.length)]; 
		boolean func = true;  
		int position = 0;
		String auxText = ""; //como não sei criar um vetor sem saber o tamanho, vou para gambiarra
		
		for (int i=0;i<vetor1.length;i++) {
			System.out.println("Informe o "+(i+1)+"º valor do 1º vetor ");
			vetor1[i] = tec.nextInt();
		} 
		for (int i=0;i<vetor2.length;i++) {
			System.out.println("Informe o "+(i+1)+"º valor do 2º vetor ");
			vetor2[i] = tec.nextInt();
		}  
				
		for (int object: vetor1) { //concatena os vetores
			aux[position] = object;
			position++;
		}
		for (int object: vetor2) { //concatena os vetores
			aux[position] = object;
			position++;
		}
		
		position = aux[0]; 
		for (int i=0;i<aux.length;i++) { //comparo a posição atual com todo o vetor, se eu achar algo, reporto como false;
			func = true;
			for(int j=0;j<aux.length;j++) {
				if(i!=j) {
					if(aux[i]==aux[j]) { //aqui é para ele não coincidir com a propria casa
						func = false;
					}
				}
			}
			if(func) { //caso ele ache algum duplicado, não escreve o numero
				auxText += aux[i] + ";";
			}
		}
		
		String[] vetorFinal = auxText.split(";");
		for(int k = 0;k<vetorFinal.length;k++) {
			System.out.println((k+1)+"ª posição: "+vetorFinal[k]);
		}
	}
}