package lista2;
//Fa�a um programa que dados 2 vetores inteiros de tamanhos 10 e 5, respectivamente,
//calcule e mostre 2 vetores resultantes:

//1 - no primeiro vetor resultante, cada elemento ser� composto pela soma de cada
//n�mero par do primeiro vetor somado a todos os n�meros do segundo vetor;

//2 - o segundo vetor resultante ser� composto pela quantidade de divisores que cada
//n�mero �mpar do primeiro vetor tem no segundo vetor.

public class exercicio3 {
	public static void main(String[] args) {
		int[] vetor1 = {1,2,3,4,5,6,7,8,9,10};
		int[] vetor2 = {4,5,3,6,2};
		
		
		int aux = 0; //quest�o 1, soma dos pares de vetor1 + o vetor2;
		String aux2 = "";		
		for(int i=0;i<vetor2.length;i++) { //todos os numeros do segundo vetor
			aux +=vetor2[i];
		}
		for(int i=0;i<vetor1.length;i++) { //pega os pares de v1
			if(vetor1[i]%2==0) {aux2 += (vetor1[i]+aux)+";";}
		}			
		String[] vetorQuestao1 = aux2.split(";");
		for(int k = 0;k<vetorQuestao1.length;k++) {
			System.out.println((k+1)+"� posi��o: "+vetorQuestao1[k]);
		}
		
		aux2 = ""; //gambiarra dnv, novamente n�o sei sobre vetor sem tamanho
		for (int i=0;i<vetor1.length;i++) {
			if(vetor1[i]%2==1) {
				for(int j=0;j<vetor2.length;j++) {
					if(vetor1[i]%vetor2[j]==0) {
						aux2 += vetor2[j]+";";
					}
				}
			}
		}
		String[] vetorQuestao2 = aux2.split(";");
		for(int k = 0;k<vetorQuestao2.length;k++) {
			System.out.println((k+1)+"� posi��o: "+vetorQuestao2[k]);
		}			
	}
}
