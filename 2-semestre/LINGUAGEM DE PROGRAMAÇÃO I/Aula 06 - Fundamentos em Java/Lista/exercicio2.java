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
		String auxText = ""; //como n�o sei criar um vetor sem saber o tamanho, vou para gambiarra
		
		for (int i=0;i<vetor1.length;i++) {
			System.out.println("Informe o "+(i+1)+"� valor do 1� vetor ");
			vetor1[i] = tec.nextInt();
		} 
		for (int i=0;i<vetor2.length;i++) {
			System.out.println("Informe o "+(i+1)+"� valor do 2� vetor ");
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
		for (int i=0;i<aux.length;i++) { //comparo a posi��o atual com todo o vetor, se eu achar algo, reporto como false;
			func = true;
			for(int j=0;j<aux.length;j++) {
				if(i!=j) {
					if(aux[i]==aux[j]) { //aqui � para ele n�o coincidir com a propria casa
						func = false;
					}
				}
			}
			if(func) { //caso ele ache algum duplicado, n�o escreve o numero
				auxText += aux[i] + ";";
			}
		}
		
		String[] vetorFinal = auxText.split(";");
		for(int k = 0;k<vetorFinal.length;k++) {
			System.out.println((k+1)+"� posi��o: "+vetorFinal[k]);
		}
	}
}