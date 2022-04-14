package lista2;
//Faça um programa que, dados 2 vetores, gere um terceiro com todos os 
//valores ordenados de maneira decrescente
import java.util.Scanner;

public class exercicio1 {

	public static void main(String[] args) {
		Scanner tec = new Scanner (System.in);
		System.out.println("Informe o tamanho do primeiro vetor: ");
        int x = tec.nextInt();
        int[] vetor1 = new int[x];
        for (int i=0;i<vetor1.length;i++) { //peguei o 1 vetor
    		System.out.println("Informe o "+(i+1)+"º valor do vetor: ");
    		vetor1[i] = tec.nextInt();
        }        
		System.out.println("Informe o tamanho do segundo vetor: ");
        x = tec.nextInt();
        int[] vetor2 = new int[x];
        for (int i=0;i<vetor2.length;i++) { //peguei o 2 vetor
    		System.out.println("Informe o "+(i+1)+"º valor do vetor: ");
    		vetor2[i] = tec.nextInt();
        }        
		int[] aux = new int[(vetor1.length+vetor2.length)]; //gerei um vetor para concatenar 
		//os valores dos vetores
		int[] ordenaVetor = new int[(vetor1.length+vetor2.length)]; //esse será o vetor final
		int position = 0; 
		for (int object: vetor1) { //concatena os vetores
			aux[position] = object;
			position++;
		}
		for (int object: vetor2) { //concatena os vetores
			aux[position] = object;
			position++;
		}
		for (int i = 0;i < ordenaVetor.length;i++) {
			for (int j = 0;j < ordenaVetor.length;j++) {
				if(aux[j] > ordenaVetor[i]) {
					ordenaVetor[i] = aux[j];
					position = j;
				}
			}
			aux[position] = 0;
		}
		for(int k = 0;k<ordenaVetor.length;k++) {
			System.out.println((k+1)+"ª posição: "+ordenaVetor[k]);
		}
		
	}
}
